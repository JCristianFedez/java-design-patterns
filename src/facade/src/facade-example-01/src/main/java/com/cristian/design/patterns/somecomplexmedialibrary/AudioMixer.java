package com.cristian.design.patterns.somecomplexmedialibrary;

import java.io.File;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AudioMixer {

  public File fix(final VideoFile result) {
    LOGGER.debug("AudioMixer: fixing audio...");
    return new File("tmp");
  }
}
