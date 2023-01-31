package com.cristian.design.patterns.models;

import java.util.Arrays;

public abstract class DwarvenMineWorker {

  public void goToSleep() {
    System.out.printf("{} goes to sleep.%n", name());
  }

  public void wakeUp() {
    System.out.printf("{} wake up.%n", name());
  }

  public void goHome() {
    System.out.printf("{} goes home.%n", name());
  }

  public void goToMine() {
    System.out.printf("{} goes to the mine.%n", name());
  }

  public void actions(final Action... actions) {
    Arrays.stream(actions).forEach(action -> action.apply(this));
  }

  public abstract String name();

  public abstract void work();

  public enum Action implements ActionOperation {
    GO_TO_SLEEP {
      @Override
      public void apply(final DwarvenMineWorker dwarvenMineWorker) {
        dwarvenMineWorker.goToSleep();
      }
    },
    WAKE_UP {
      @Override
      public void apply(final DwarvenMineWorker dwarvenMineWorker) {
        dwarvenMineWorker.wakeUp();
      }
    },
    GO_HOME {
      @Override
      public void apply(final DwarvenMineWorker dwarvenMineWorker) {
        dwarvenMineWorker.goHome();
      }
    },
    GO_TO_MINE {
      @Override
      public void apply(final DwarvenMineWorker dwarvenMineWorker) {
        dwarvenMineWorker.goToMine();
      }
    },
    WORK {
      @Override
      public void apply(final DwarvenMineWorker dwarvenMineWorker) {
        dwarvenMineWorker.work();
      }
    }

  }

  interface ActionOperation {

    void apply(DwarvenMineWorker dwarvenMineWorker);
  }
}
