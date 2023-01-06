package com.cristian.design.patterns;

class Scout extends EventEmitter {

  public Scout(EventObserver obs, Event e) {
    super(obs, e);
  }

  public Scout() {
  }

  @Override
  public void timePasses(final Weekday day) {
    if (Weekday.TUESDAY.equals(day)) {
      notifyObservers(Event.WARSHIPS_APPROACHING);
    } else if (Weekday.WEDNESDAY.equals(day)) {
      notifyObservers(Event.WHITE_WALKERS_SIGHTED);
    }
  }
}
