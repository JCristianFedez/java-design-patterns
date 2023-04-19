package com.cristian.design.patterns;

import java.util.HashSet;
import java.util.Set;

public abstract class ObjectPool<T> {

  private final Set<T> available = new HashSet<>();

  private final Set<T> inUse = new HashSet<>();

  protected abstract T create();

  public synchronized T checkOut() {
    if (this.available.isEmpty()) {
      this.available.add(create());
    }
    final T instance = this.available.iterator().next();
    this.available.remove(instance);
    this.inUse.add(instance);
    return instance;
  }

  public synchronized void checkIn(final T instance) {
    this.inUse.remove(instance);
    this.available.add(instance);
  }

  @Override
  public synchronized String toString() {
    return String.format("Pool available=%d inUse=%d", this.available.size(), this.inUse.size());
  }
}
