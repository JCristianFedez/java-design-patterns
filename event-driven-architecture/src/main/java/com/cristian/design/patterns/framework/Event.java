package com.cristian.design.patterns.framework;

public interface Event {

  /**
   * Returns the message type as a {@link Class} object. In this example the message type is used to handle events by their type.
   *
   * @return the message type as a {@link class}
   */
  Class<? extends Event> getType();
}
