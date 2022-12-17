package com.cristian.design.patterns.somecomplexmedialibrary;

import java.io.File;

import com.cristian.design.patterns.logger.Logger;

public class AudioMixer {

  private static final Logger LOGGER = Logger.fromType(AudioMixer.class);

  public File fix(final VideoFile result) {
    LOGGER.debug("AudioMixer: fixing audio...");
    return new File("tmp");
  }
}
