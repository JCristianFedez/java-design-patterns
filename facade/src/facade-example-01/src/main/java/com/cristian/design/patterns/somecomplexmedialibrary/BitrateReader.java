package com.cristian.design.patterns.somecomplexmedialibrary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BitrateReader {

  public static VideoFile read(final VideoFile file, final Codec codec) {
    LOGGER.debug("BitrateReader: reading file...");
    return file;
  }

  public static VideoFile convert(final VideoFile buffer, final Codec codec) {
    LOGGER.debug("BitrateReader: writing file...");
    return buffer;
  }
}
