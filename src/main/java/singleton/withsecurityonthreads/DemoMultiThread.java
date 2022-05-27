package singleton.withsecurityonthreads;

import commons.logger.Logger;

public class DemoMultiThread {

  private static final Logger LOGGER = Logger.fromType(DemoMultiThread.class);

  public static void main(String[] args) {
    final Thread threadFoo = buildSingletonInThread("FOO");
    final Thread threadBar = buildSingletonInThread("BAR");

    threadFoo.start();
    threadBar.start();
  }

  private static Thread buildSingletonInThread(final String value) {
    return new Thread(() -> {
      final Singleton singleton = Singleton.getInstance(value);
      LOGGER.info(singleton.toString());
    });
  }
}
