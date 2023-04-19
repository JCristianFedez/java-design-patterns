package com.cristian.design.patterns.listeners;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailNotificationListener implements EventListener {

  private final String email;

  public EmailNotificationListener(final String email) {
    this.email = email;
  }

  @Override
  public void update(final String eventType, final File file) {
    LOGGER.debug("Email para {}: Alguien ha actuado {} operación con el siguiente archivo {}", this.email, eventType, file.getName());
  }
}
