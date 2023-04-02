package com.cristian.design.patterns.ejemplo1.ingenuo.multihilo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoMultiThread {

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
