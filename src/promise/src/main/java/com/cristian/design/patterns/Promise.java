package com.cristian.design.patterns;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Function;

import lombok.AllArgsConstructor;

public class Promise<T> extends PromiseSupport<T> {

  private Runnable fulfillmentAction;

  private Consumer<? super Throwable> exceptionHandler;

  /**
   * Fulfills the promise with the provided value.
   *
   * @param value the fulfilled value that can be accessed using {@link #get()}.
   */
  @Override
  protected void fulfill(final T value) {
    super.fulfill(value);
    postFulfillment();
  }

  /**
   * Fulfills the promise with exception due to error in execution.
   *
   * @param exception the exception will be wrapped in {@link ExecutionException} when accessing the value using {@link #get()}.
   */
  @Override
  public void fulfillExceptionally(Exception exception) {
    super.fulfillExceptionally(exception);
    handleException(exception);
    postFulfillment();
  }

  /**
   * Executes the task using the executor in other thread and fulfills the promise returned once the task completes either successfully or
   * with an exception.
   *
   * @param task the task that will provide the value to fulfill the promise.
   * @param executor the executor in which the task should be run.
   * @return a promise that represents the result of running the task provided.
   */
  public Promise<T> fulfillInAsync(final Callable<T> task, final Executor executor) {
    executor.execute(() -> {
      try {
        fulfill(task.call());
      } catch (Exception e) {
        fulfillExceptionally(e);
      }
    });
    return this;
  }

  /**
   * Returns a new promise that, when this promise is fulfilled normally, is fulfilled with result of this promise as argument to the action
   * provided.
   *
   * @param action action to be executed.
   * @return a new promise.
   */
  public Promise<Void> thenAccept(final Consumer<? super T> action) {
    final Promise<Void> dest = new Promise<>();
    this.fulfillmentAction = new ConsumeAction(this, dest, action);
    return dest;
  }

  /**
   * Set the exception handler on this promise.
   *
   * @param exceptionHandler a consumer that will handle the exception occurred while fulfilling the promise.
   * @return this
   */
  public Promise<T> onError(Consumer<? super Throwable> exceptionHandler) {
    this.exceptionHandler = exceptionHandler;
    return this;
  }

  /**
   * Returns a new promise that, when this promise is fulfilled normally, is fulfilled with result of this promise as argument to the
   * function provided.
   *
   * @param func function to be executed.
   * @return a new promise.
   */
  public <V> Promise<V> thenApply(final Function<? super T, V> func) {
    final Promise<V> dest = new Promise<>();
    this.fulfillmentAction = new TransformAction<>(this, dest, func);
    return dest;
  }

  private void postFulfillment() {
    if (this.fulfillmentAction != null) {
      this.fulfillmentAction.run();
    }
  }

  private void handleException(final Exception exception) {
    if (this.exceptionHandler != null) {
      this.exceptionHandler.accept(exception);
    }
  }

  /**
   * Accesses the value from source promise and calls the consumer, then fulfills the destination promise.
   */
  @AllArgsConstructor
  private class ConsumeAction implements Runnable {

    private final Promise<T> src;

    private final Promise<Void> dest;

    private final Consumer<? super T> action;

    @Override
    public void run() {
      try {
        this.action.accept(this.src.get());
      } catch (Throwable e) {
        this.dest.fulfillExceptionally((Exception) e.getCause());
      }
    }
  }

  /**
   * Accesses the value from source promise, then fulfills the destination promise using the transformed value. The source value is
   * transformed using the transformation function.
   */
  @AllArgsConstructor
  private class TransformAction<V> implements Runnable {

    private final Promise<T> src;

    private final Promise<V> dest;

    private final Function<? super T, V> func;

    @Override
    public void run() {
      try {
        this.dest.fulfill(this.func.apply(this.src.get()));
      } catch (Throwable throwable) {
        this.dest.fulfillExceptionally((Exception) throwable.getCause());
      }
    }
  }
}
