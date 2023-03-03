package com.cristian.design.patterns;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MuteIdiomDemo {

  public static void main(String[] args) {
    new MuteIdiomDemo().run();
  }

  private void run() {
    useOfLoggedMute();

    useOfMute();
  }

  /*
   * Typically used when the API declares some exception but cannot do so. Usually a
   * signature mistake.In this example out is not supposed to throw exception as it is a
   * ByteArrayOutputStream. So we utilize mute, which will throw AssertionError if unexpected
   * exception occurs.
   */
  private void useOfMute() {
    LOGGER.info("=================START OF MUTE=================");

    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    Mute.mute(() -> out.write("Hello".getBytes()));

    LOGGER.info("=================END OF MUTE=================");
  }

  private void useOfLoggedMute() {
    LOGGER.info("=================START OF LOGGED MUTE=================");

    Optional<Resource> resource = Optional.empty();
    try {
      resource = Optional.of(new AcquireResource());
      utilizeResource(resource.get());
    } finally {
      resource.ifPresent(this::closeResource);
    }

    LOGGER.info("=================END OF LOGGED MUTE=================");
  }

  /*
   * All we can do while failed close of a resource is to log it.
   */
  private void closeResource(final Resource resource) {
    Mute.loggedMute(resource::close);
  }

  private void utilizeResource(final Resource resource) {
    LOGGER.info("Utilizing acquired resource: {}", resource);
  }

  private static final class AcquireResource implements Resource {

    @Override
    public void close() throws IOException {
      throw new IOException(String.format("Error in closing resource: %s", this));
    }
  }

}
