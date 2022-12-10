package activeobject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import commons.logger.Logger;

abstract class ActiveCreature {

  private static final Logger LOGGER = Logger.fromType(ActiveCreature.class);

  private final BlockingQueue<Runnable> request;

  private final String name;

  protected ActiveCreature(final String name) {
    this.name = name;
    this.request = new LinkedBlockingQueue<>();
    Thread thread = new Thread(() -> {
      while (true) {
        try {
          this.request.take().run();
        } catch (InterruptedException e) {
          LOGGER.exception(e);
          Thread.currentThread().interrupt();
        }
      }
    });
    thread.start();
  }

  public void eat() throws InterruptedException {
    this.request.put(() -> {
      LOGGER.info("%s is eating!", getName());
      LOGGER.info("%s has finished eating!", getName());
    });
  }

  public void roam() throws InterruptedException {
    this.request.put(() -> LOGGER.info("%s has started to roam the wastelands", getName()));
  }

  public String getName() {
    return this.name;
  }
}
