package com.cristian.design.patterns;

import java.io.File;

import com.cristian.design.patterns.logger.Logger;
import com.cristian.design.patterns.somecomplexmedialibrary.AudioMixer;
import com.cristian.design.patterns.somecomplexmedialibrary.BitrateReader;
import com.cristian.design.patterns.somecomplexmedialibrary.Codec;
import com.cristian.design.patterns.somecomplexmedialibrary.CodecFactory;
import com.cristian.design.patterns.somecomplexmedialibrary.MPEG4CompressionCodec;
import com.cristian.design.patterns.somecomplexmedialibrary.OggCompressionCodec;
import com.cristian.design.patterns.somecomplexmedialibrary.VideoFile;

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
