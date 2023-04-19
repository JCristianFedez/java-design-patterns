package com.cristian.design.patterns.db;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaintenanceLock {

  private static MaintenanceLock instance;
  private boolean lock = true;

  public static synchronized MaintenanceLock getInstance() {
    if (instance == null) {
      instance = new MaintenanceLock();
    }
    return instance;
  }

  public boolean isLock() {
    return this.lock;
  }

  public void setLock(final boolean lock) {
    this.lock = lock;
    LOGGER.info("Maintenance lock is set to: {}", this.lock);
  }
}
