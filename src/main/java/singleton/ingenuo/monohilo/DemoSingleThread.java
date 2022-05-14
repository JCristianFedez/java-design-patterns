package singleton.ingenuo.monohilo;

import commons.logger.Logger;

class DemoSingleThread {

  private static final Logger LOGGER = Logger.fromType(DemoSingleThread.class);

  public static void main(String[] args) {
    final Singleton singleton = Singleton.getInstance("FOO");
    final Singleton anotherSingleton = Singleton.getInstance("BAR");

    LOGGER.debug("Singleton1: %s", singleton);
    LOGGER.debug("Singleton2: %s", anotherSingleton);
  }
}
