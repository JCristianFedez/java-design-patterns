package com.cristian.design.patterns;

public class Demo {

  public static void main(String[] args) {
    final VideoConversionFacade converter = new VideoConversionFacade();
    converter.convertVideo("youtubevideo.ogg", "mp4");
  }
}
