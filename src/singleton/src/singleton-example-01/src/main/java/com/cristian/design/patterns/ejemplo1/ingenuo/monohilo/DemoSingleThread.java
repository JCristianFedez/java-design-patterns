package com.cristian.design.patterns.ejemplo1.ingenuo.monohilo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DemoSingleThread {

  public static void main(String[] args) {
    final Singleton singleton = Singleton.getInstance("FOO");
    final Singleton anotherSingleton = Singleton.getInstance("BAR");

    LOGGER.debug("Singleton1: {}", singleton);
    LOGGER.debug("Singleton2: {}", anotherSingleton);
  }
}
