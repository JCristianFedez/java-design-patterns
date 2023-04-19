package com.cristian.design.patterns.domain;

import java.security.SecureRandom;

import com.cristian.design.patterns.Lockable;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Feind implements Runnable {

  private static final SecureRandom RANDOM = new SecureRandom();

  private final Creature creature;

  private final Lockable target;

  @Override
  public void run() {
    if (!this.creature.acquire(this.target)) {
      fightForTheSword(this.creature, this.target.getLocker(), this.target);
    } else {
      LOGGER.info("{} has acquired the sword!", target.getLocker().getName());
    }
  }

  /**
   * Keeps on fighting until the Lockable is possessed.
   *
   * @param reacher as the source creature.
   * @param holder as the foe.
   * @param sword as the Lockable to possess.
   */
  private void fightForTheSword(final Creature reacher, final Creature holder, final Lockable sword) {
    LOGGER.info("A duel between {} and {} has been started!", reacher.getName(), holder.getName());
    while (this.target.isLocked() && reacher.isAlive() && holder.isAlive()) {
      if (RANDOM.nextBoolean()) {
        reacher.attack(holder);
      } else {
        holder.attack(reacher);
      }
    }
    if (reacher.isAlive()) {
      if (!reacher.acquire(sword)) {
        fightForTheSword(reacher, sword.getLocker(), sword);
      } else {
        LOGGER.info("{} has acquired the sword!", reacher.getName());
      }
    }
  }
}
