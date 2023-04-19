package com.cristian.design.patterns.somecomplexmedialibrary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodecFactory {

  public static Codec extract(final VideoFile file) {
    final String type = file.getCodecType();
    if (type.equals("mp4")) {
      LOGGER.debug("CodecFactory: extracting mpeg audio...");
      return new MPEG4CompressionCodec();
    } else {
      LOGGER.debug("CodecFactory: extracting ogg audio...");
      return new OggCompressionCodec();
    }
  }
}
