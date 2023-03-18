package com.cristian.design.patterns;

import java.io.Closeable;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TreasureChest implements Closeable {

  public TreasureChest() {
    LOGGER.info("Treasure chest opens.");
  }

  @Override
  public void close() throws IOException {
    LOGGER.info("Treasure chest closes.");
  }
}
