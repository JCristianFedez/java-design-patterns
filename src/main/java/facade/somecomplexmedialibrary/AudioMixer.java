package facade.somecomplexmedialibrary;

import java.io.File;

import commons.logger.Logger;

public class AudioMixer {

  private static final Logger LOGGER = Logger.fromType(AudioMixer.class);

  public File fix(final VideoFile result) {
    LOGGER.debug("AudioMixer: fixing audio...");
    return new File("tmp");
  }
}
