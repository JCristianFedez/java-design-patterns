package com.cristian.design.patterns;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

abstract class EventEmitter {

  private final Map<Event, List<EventObserver>> observers = new HashMap<>();

  protected EventEmitter(final EventObserver observer, final Event event) {
    registerObserver(observer, event);
  }

  protected EventEmitter() {
  }

  public void registerObserver(final EventObserver observer, final Event event) {
    if (!this.observers.containsKey(event)) {
      this.observers.put(event, new LinkedList<>());
    }
    if (!this.observers.get(event).contains(observer)) {
      this.observers.get(event).add(observer);
    }
  }

  protected void notifyObservers(final Event event) {
    if (this.observers.containsKey(event)) {
      this.observers.get(event).forEach(observer -> observer.onEvent(event));
    }
  }

  public abstract void timePasses(Weekday day);

}
