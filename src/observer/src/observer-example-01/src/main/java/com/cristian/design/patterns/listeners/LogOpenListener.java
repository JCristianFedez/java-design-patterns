package com.cristian.design.patterns.listeners;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogOpenListener implements EventListener {

  private final File logFile;

  public LogOpenListener(final String fileName) {
    this.logFile = new File(fileName);
  }

  @Override
  public void update(final String eventType, final File file) {
    LOGGER.debug("Guardando log {}: Alguien ha actuado {} operación con el siguiente archivo {}", this.logFile, eventType, file.getName());
  }
}
