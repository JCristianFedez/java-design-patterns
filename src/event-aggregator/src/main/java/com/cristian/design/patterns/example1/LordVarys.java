package com.cristian.design.patterns.example1;

class LordVarys extends EventEmitter implements EventObserver {

  public LordVarys(EventObserver obs, Event e) {
    super(obs, e);
  }

  public LordVarys() {
  }

  @Override
  public void timePasses(final Weekday day) {
    if (Weekday.SATURDAY.equals(day)) {
      notifyObservers(Event.TRAITOR_DETECTED);
    }
  }

  @Override
  public void onEvent(final Event event) {
    notifyObservers(event);
  }
}
