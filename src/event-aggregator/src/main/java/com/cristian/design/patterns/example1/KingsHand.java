package com.cristian.design.patterns.example1;

class KingsHand extends EventEmitter implements EventObserver {

  public KingsHand() {
    super();
  }

  public KingsHand(EventObserver obs, Event e) {
    super(obs, e);
  }

  @Override
  public void timePasses(final Weekday day) {
  }

  @Override
  public void onEvent(final Event event) {
    notifyObservers(event);
  }
}
