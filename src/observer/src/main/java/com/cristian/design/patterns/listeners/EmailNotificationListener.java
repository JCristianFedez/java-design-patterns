package com.cristian.design.patterns.listeners;

import java.io.File;

import com.cristian.design.patterns.logger.Logger;

public class EmailNotificationListener implements EventListener {

  private static final Logger LOGGER = Logger.fromType(EmailNotificationListener.class);

  private final String email;

  public EmailNotificationListener(final String email) {
    this.email = email;
  }

  @Override
  public void update(final String eventType, final File file) {
    LOGGER.debug("Email para %s: Alguien ha actuado %s operación con el siguiente archivo %s", this.email, eventType, file.getName());
  }
}
