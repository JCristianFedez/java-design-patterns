package com.cristian.design.patterns;

class LordBaelish extends EventEmitter {

  public LordBaelish(final EventObserver observer, final Event event) {
    super(observer, event);
  }

  @Override
  public void timePasses(final Weekday day) {
    if (Weekday.FRIDAY.equals(day)) {
      notifyObservers(Event.STARK_SIGHTED);
    }
  }
}
