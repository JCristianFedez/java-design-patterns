package com.cristian.design.patterns;

import java.io.Closeable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceAcquisitionIsInitializationDemo {

  public static void main(String[] args) throws Exception {

    try (final AutoCloseable ignored = new SlidingDoor()) {
      LOGGER.info("Walking in.");
    }

    try (final Closeable ignored = new TreasureChest()) {
      LOGGER.info("Looting contents.");
    }
  }
}
