package com.cristian.design.patterns.view;

import com.cristian.design.patterns.model.GiantModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GiantView {

  public void displayGiant(final GiantModel model) {
    LOGGER.info(model.toString());
  }
}
