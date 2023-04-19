package com.cristian.design.patterns;

/**
 * Singleton class. Eagerly initialized static instance guarantees thread safety.
 */
public class IvoryTower {

  private static final IvoryTower INSTANCE = new IvoryTower();

  private IvoryTower() {
  }

  public static IvoryTower getInstance() {
    return INSTANCE;
  }
}
