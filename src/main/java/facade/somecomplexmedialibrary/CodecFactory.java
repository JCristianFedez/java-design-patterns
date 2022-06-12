package facade.somecomplexmedialibrary;

import commons.logger.Logger;

public class CodecFactory {

  private static final Logger LOGGER = Logger.fromType(CodecFactory.class);

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
