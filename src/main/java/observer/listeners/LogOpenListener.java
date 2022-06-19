package observer.listeners;

import java.io.File;

import commons.logger.Logger;

public class LogOpenListener implements EventListener {
  private static final Logger LOGGER = Logger.fromType(LogOpenListener.class);

  private File log;

  public LogOpenListener(final String fileName) {
    this.log = new File(fileName);
  }

  @Override
  public void update(final String eventType, final File file) {
    LOGGER.debug("Guardando log %s: Alguien ha actuado %s operación con el siguiente archivo %s", this.log, eventType, file.getName());
  }
}
