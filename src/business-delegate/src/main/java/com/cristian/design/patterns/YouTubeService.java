package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
final class YouTubeService implements VideoStreamingService {

  @Override
  public void doProcessing() {
    LOGGER.info("YouTubeService is now processing");
  }
}
