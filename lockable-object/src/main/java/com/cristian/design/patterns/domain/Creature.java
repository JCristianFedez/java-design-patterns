package com.cristian.design.patterns.domain;

import java.util.HashSet;
import java.util.Set;

import com.cristian.design.patterns.Lockable;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public abstract class Creature {

  private final String name;

  private final CreatureType type;

  private final Set<Lockable> instruments = new HashSet<>();

  private final int damage;

  private int health;

  protected Creature(final String name, final CreatureType type) {
    this.name = name;
    this.type = type;
    this.health = type.getBaseHealth();
    this.damage = type.getBaseDamage();
  }

  public boolean acquire(final Lockable lockable) {
    if (lockable.lock(this)) {
      this.instruments.add(lockable);
      return true;
    }
    return false;
  }

  /**
   * Terminates the {@link Creature} and unlocks all of the {@link Lockable} that it poses.
   */
  public synchronized void kill() {
    LOGGER.info("{} {} has been slayed", this.type, this.name);
    this.instruments.forEach(instrument -> instrument.unlock(this));
    this.instruments.clear();
  }

  public synchronized void attack(final Creature creature) {
    creature.hit(getDamage());
  }

  public synchronized void hit(final int damage) {
    if (damage < 0) {
      throw new IllegalArgumentException("Damage cannot be a negative number");
    }
    if (isAlive()) {
      setHealth(getHealth() - damage);
      if (!isAlive()) {
        kill();
      }
    }
  }

  public synchronized boolean isAlive() {
    return getHealth() > 0;
  }
}
