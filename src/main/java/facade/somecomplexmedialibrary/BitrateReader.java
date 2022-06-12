package facade.somecomplexmedialibrary;

import commons.logger.Logger;

public class BitrateReader {

  private static final Logger LOGGER = Logger.fromType(BitrateReader.class);

  public static VideoFile read(final VideoFile file, final Codec codec) {
    LOGGER.debug("BitrateReader: reading file...");
    return file;
  }

  public static VideoFile convert(final VideoFile buffer, final Codec codec) {
    LOGGER.debug("BitrateReader: writing file...");
    return buffer;
  }
}
