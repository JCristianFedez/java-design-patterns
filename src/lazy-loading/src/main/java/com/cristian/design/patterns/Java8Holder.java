package com.cristian.design.patterns;

import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Java8Holder {

  private Supplier<Heavy> heavy = this::createdAndCacheHeavy;

  public Java8Holder() {
    LOGGER.info("Java8Holder created");
  }

  public Heavy heavy() {
    return this.heavy.get();
  }

  private synchronized Heavy createdAndCacheHeavy() {
    class HeavyFactory implements Supplier<Heavy> {

      private final Heavy heavyInstance = new Heavy();

      @Override
      public Heavy get() {
        return this.heavyInstance;
      }
    }

    if (!HeavyFactory.class.isAssignableFrom(this.heavy.getClass())) {
      this.heavy = new HeavyFactory();
    }
    return this.heavy.get();
  }

}
