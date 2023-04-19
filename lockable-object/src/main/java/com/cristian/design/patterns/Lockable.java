package com.cristian.design.patterns;

import com.cristian.design.patterns.domain.Creature;

public interface Lockable {

  boolean isLocked();

  boolean lock(Creature creature);

  void unlock(Creature creature);

  Creature getLocker();

  String getName();
}
