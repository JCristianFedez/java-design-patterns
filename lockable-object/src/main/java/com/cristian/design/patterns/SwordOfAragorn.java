package com.cristian.design.patterns;

import com.cristian.design.patterns.domain.Creature;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SwordOfAragorn implements Lockable {

  private static final String NAME = "The Sword of Aragorn";

  private final Object synchronizer = new Object();

  @Getter
  private Creature locker;

  @Override
  public boolean isLocked() {
    return this.locker != null;
  }

  @Override
  public boolean lock(final Creature creature) {
    synchronized (this.synchronizer) {
      LOGGER.info("{} is now trying to acquire {}", creature.getName(), this.getName());
      if (!isLocked()) {
        this.locker = creature;
        return true;
      }
    }
    return false;
  }

  @Override
  public void unlock(final Creature creature) {
    synchronized (this.synchronizer) {
      if (this.locker != null && this.locker.getName().equals(creature.getName())) {
        this.locker = null;
        LOGGER.info("{} is now free", this.getName());
      }
      if (this.locker != null) {
        throw new LockingException("You cannot unlock an object you are not the owner of.");
      }
    }
  }

  @Override
  public String getName() {
    return NAME;
  }

}
