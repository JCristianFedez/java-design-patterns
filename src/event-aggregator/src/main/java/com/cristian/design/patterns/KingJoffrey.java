package com.cristian.design.patterns;

class KingJoffrey implements EventObserver {

  @Override
  public void onEvent(final Event event) {
    System.out.printf("Received event from the King's Hand: %s%n", event.toString());
  }
}
