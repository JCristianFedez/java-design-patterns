package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
final class Demo {

  public static void main(String[] args) {
    final SimpleTask simpleTask = new SimpleTask();
    simpleTask.executeWith(() -> log.info("I'm done now."));
  }
}
