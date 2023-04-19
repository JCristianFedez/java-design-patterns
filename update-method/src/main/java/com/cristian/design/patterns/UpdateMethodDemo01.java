package com.cristian.design.patterns;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import com.cristian.design.patterns.entities.Skeleton;
import com.cristian.design.patterns.entities.Statue;

public class UpdateMethodDemo01 {

  private static final int GAME_RUNNING_TIME = 2000;

  public static void main(String[] args) {
    final World world = new World();
    final Skeleton skeleton1 = new Skeleton(1, 10);
    final Skeleton skeleton2 = new Skeleton(2, 70);
    final Statue statue = new Statue(3, 20);
    world.addEntity(skeleton1);
    world.addEntity(skeleton2);
    world.addEntity(statue);
    world.run();
    LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(GAME_RUNNING_TIME));
    world.stop();
  }
}
