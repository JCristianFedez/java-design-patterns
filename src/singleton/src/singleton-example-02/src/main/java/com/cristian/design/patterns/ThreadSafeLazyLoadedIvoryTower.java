package com.cristian.design.patterns;

/**
 * <p>Thread-safe Singleton class. The instance is lazily initialized and thus needs synchronization mechanism.</p>
 */
public class ThreadSafeLazyLoadedIvoryTower {

  private static volatile ThreadSafeLazyLoadedIvoryTower instance;

  private ThreadSafeLazyLoadedIvoryTower() {
    // Protect against instantiation via reflection.
    if (ThreadSafeLazyLoadedIvoryTower.instance != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * The instance doesn't get created until the method is called for the first time.
   */
  public static synchronized ThreadSafeLazyLoadedIvoryTower getInstance() {
    if (ThreadSafeLazyLoadedIvoryTower.instance == null) {
      ThreadSafeLazyLoadedIvoryTower.instance = new ThreadSafeLazyLoadedIvoryTower();
    }
    return ThreadSafeLazyLoadedIvoryTower.instance;
  }
}
