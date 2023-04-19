package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Inventory {

  private final int inventorySize;

  private final List<Item> items;

  private final Lock lock;

  public Inventory(final int inventorySize) {
    this.inventorySize = inventorySize;
    this.items = new ArrayList<>(inventorySize);
    this.lock = new ReentrantLock();
  }

  public boolean addItem(final Item item) {
    if (this.items.size() < this.inventorySize) {
      this.lock.lock();
      try {
        if (this.items.size() < this.inventorySize) {
          this.items.add(item);
          final Thread thread = Thread.currentThread();
          System.out.printf("{}: items.size()={}, inventorySize={}%n", thread, this.items.size(), this.inventorySize);
          return true;
        }
      } finally {
        this.lock.lock();
      }
    }
    return false;
  }

  public final List<Item> items() {
    return Collections.unmodifiableList(this.items);
  }
}
