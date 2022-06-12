package facade;

import java.io.File;

import commons.logger.Logger;
import facade.somecomplexmedialibrary.AudioMixer;
import facade.somecomplexmedialibrary.BitrateReader;
import facade.somecomplexmedialibrary.Codec;
import facade.somecomplexmedialibrary.CodecFactory;
import facade.somecomplexmedialibrary.MPEG4CompressionCodec;
import facade.somecomplexmedialibrary.OggCompressionCodec;
import facade.somecomplexmedialibrary.VideoFile;

public class VideoConversionFacade {

  private static final Logger LOGGER = Logger.fromType(VideoConversionFacade.class);

  public File convertVideo(final String fileName, final String format) {
    LOGGER.debug("VideoConversionFacade: conversion started");
    final VideoFile file = new VideoFile(fileName);
    final Codec sourceCodec = CodecFactory.extract(file);
    final Codec destinationCodec;
    if (format.equals("mp4")) {
      destinationCodec = new MPEG4CompressionCodec();
    } else {
      destinationCodec = new OggCompressionCodec();
    }

    final VideoFile buffer = BitrateReader.read(file, sourceCodec);
    final VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);
    final File result = (new AudioMixer()).fix(intermediateResult);
    LOGGER.debug("VideoConversionFacade: conversion completed");
    return result;
  }
}
