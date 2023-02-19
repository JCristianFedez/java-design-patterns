package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LazyLoadDemo {

  public static void main(String[] args) {
    new LazyLoadDemo().run();
  }

  private void run() {
    final HolderNaive holderNaive = new HolderNaive();
    final Heavy heavy = holderNaive.getHeavy();
    LOGGER.info("heavy={}", heavy);

    final HolderThreadSafe holderThreadSafe = new HolderThreadSafe();
    final Heavy another = holderThreadSafe.getHeavy();
    LOGGER.info("another={}", another);

    final Java8Holder java8Holder = new Java8Holder();
    final Heavy next = java8Holder.heavy();
    LOGGER.info("next={}", next);
  }
}
