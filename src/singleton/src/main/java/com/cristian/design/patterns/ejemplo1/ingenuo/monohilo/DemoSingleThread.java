package com.cristian.design.patterns.ejemplo1.ingenuo.monohilo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class DemoSingleThread {

  public static void main(String[] args) {
    final Singleton singleton = Singleton.getInstance("FOO");
    final Singleton anotherSingleton = Singleton.getInstance("BAR");

    log.debug("Singleton1: {}", singleton);
    log.debug("Singleton2: {}", anotherSingleton);
  }
}
