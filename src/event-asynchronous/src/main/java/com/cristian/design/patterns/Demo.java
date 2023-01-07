package com.cristian.design.patterns;

class Demo {

  public static void main(String[] args)
      throws LongRunningEventException, MaxNumOfEventsAllowedException, EventDoesNotExistException, InvalidOperationException {
    new Demo().run();
  }

  private void run()
      throws LongRunningEventException, MaxNumOfEventsAllowedException, EventDoesNotExistException, InvalidOperationException {
    final EventManager eventManager = new EventManager();

    // Create an Asynchronous event.
    final int asyncEventId = eventManager.createAsync(60);
    System.out.printf("Async event [%s] has been created.%n", asyncEventId);
    eventManager.start(asyncEventId);
    System.out.printf("Async event [%s] has been started.%n", asyncEventId);

    // Create a Synchronous event.
    final int syncEventId = eventManager.createSyncEvent(60);
    System.out.printf("Sync event [%s] has been created.%n", syncEventId);
    eventManager.start(syncEventId);
    System.out.printf("Sync event [%s] has been started.%n", syncEventId);

    eventManager.status(asyncEventId);
    eventManager.status(syncEventId);

    eventManager.cancel(asyncEventId);
    System.out.printf("Async event [%s] has been created.%n", asyncEventId);
    eventManager.cancel(syncEventId);
    System.out.printf("Sync event [%s] has been created.%n", syncEventId);
  }

}