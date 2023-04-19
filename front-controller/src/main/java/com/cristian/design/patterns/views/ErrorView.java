package com.cristian.design.patterns.views;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ErrorView implements View {

  @Override
  public void display() {
    LOGGER.error("Error 500");
  }
}
