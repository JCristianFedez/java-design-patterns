package com.cristian.design.patterns;

import com.cristian.design.patterns.superpowers.GroundDive;
import com.cristian.design.patterns.superpowers.SkyLaunch;
import com.cristian.design.patterns.superpowers.Superpower;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassSandBoxDemo {

  public static void main(String[] args) {
    LOGGER.info("Use superpower: Sky launch");
    final Superpower skyLaunch = new SkyLaunch();
    skyLaunch.activate();

    LOGGER.info("Use superpower: ground dive");
    final Superpower groundDive = new GroundDive();
    groundDive.activate();
  }
}
