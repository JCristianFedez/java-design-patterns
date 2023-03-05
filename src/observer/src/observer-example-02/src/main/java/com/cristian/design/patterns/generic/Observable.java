package com.cristian.design.patterns.generic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import lombok.Getter;

public abstract class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {

  @Getter
  private final List<O> observers = new CopyOnWriteArrayList<>();

  public void addObserver(final O observer) {
    this.observers.add(observer);
  }

  public void removeObserver(final O observer) {
    this.observers.remove(observer);
  }

  @SuppressWarnings("unchecked")
  public void notifyObservers(final A argument) {
    this.observers.forEach(observer -> observer.update((S) this, argument));
  }

}
