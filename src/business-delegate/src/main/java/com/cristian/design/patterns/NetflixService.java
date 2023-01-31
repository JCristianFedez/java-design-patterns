package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NetflixService implements VideoStreamingService {

  @Override
  public void doProcessing() {
    log.info("NetflixService is now processing");
  }
}
