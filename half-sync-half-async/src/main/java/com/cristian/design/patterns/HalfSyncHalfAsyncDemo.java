package com.cristian.design.patterns;

import java.util.concurrent.LinkedBlockingQueue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HalfSyncHalfAsyncDemo {

  public static void main(String[] args) {
    new HalfSyncHalfAsyncDemo().run();
  }

  private static long ap(long i) {
    try {
      Thread.sleep(i);
    } catch (InterruptedException e) {
      LOGGER.error("Exception caught.", e);
    }
    return i * (i + 1) / 2;
  }

  private void run() {
    final AsynchronousService service = new AsynchronousService(new LinkedBlockingQueue<>());

    /*
     * A new task to calculate sum is received but as this is main thread, it should not block. So
     * it passes it to the asynchronous task layer to compute and proceeds with handling other
     * incoming requests. This is particularly useful when main thread is waiting on Socket to
     * receive new incoming requests and does not wait for particular request to be completed before
     * responding to new request.
     */
    service.execute(new ArithmeticSumTask(1000));

    /*
     * New task received, lets pass that to async layer for computation. So both requests will be
     * executed in parallel.
     */
    service.execute(new ArithmeticSumTask(500));
    service.execute(new ArithmeticSumTask(2000));
    service.execute(new ArithmeticSumTask(1));

    service.close();
  }

  private record ArithmeticSumTask(long numberOfElements) implements AsyncTask<Long> {

    /*
     * This will be called in context of the main thread where some validations can be done
     * regarding the inputs. Such as it must be greater than 0. It's a small computation which can
     * be performed in main thread. If we did validated the input in background thread then we pay
     * the cost of context switching which is much more than validating it in main thread.
     */
    @Override
    public void onPreCall() {
      if (this.numberOfElements < 0) {
        throw new IllegalArgumentException("n is less than 0");
      }
    }

    @Override
    public void onPostCall(final Long result) {
      // Handle the result of computation.
      LOGGER.info(result.toString());
    }

    @Override
    public void onError(final Throwable throwable) {
      throw new IllegalStateException("Should not occur");
    }

    @Override
    public Long call() throws Exception {
      return ap(this.numberOfElements);
    }
  }
}
