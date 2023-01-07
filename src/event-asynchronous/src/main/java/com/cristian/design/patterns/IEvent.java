package com.cristian.design.patterns;

/**
 * Event that fulfill the start, stop and list out current status behaviour follow this interface.
 */
interface IEvent {

  void start();

  void stop();

  void status();
}
