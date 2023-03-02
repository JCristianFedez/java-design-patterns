package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class Server {

  @Getter
  private final String host;

  @Getter
  private final int port;

  private final int id;

  public void serve(final Request request) {
    LOGGER.info("SERVER ID {} associated to host : {} and port {}. Processed request with value {}", this.id, this.host, this.port,
        request.value());
  }

}
