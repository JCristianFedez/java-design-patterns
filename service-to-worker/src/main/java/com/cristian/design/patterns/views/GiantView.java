package com.cristian.design.patterns.views;

import com.cristian.design.patterns.models.GiantModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GiantView {

  public void displayGiant(final GiantModel giant) {
    LOGGER.info(giant.toString());
  }
}
