package com.cristian.design.patterns.example1;

class KingJoffrey implements EventObserver {

  @Override
  public void onEvent(final Event event) {
    System.out.printf("Received event from the King's Hand: {}%n", event.toString());
  }
}
