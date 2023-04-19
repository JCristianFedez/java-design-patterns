package com.cristian.design.patterns.facade;

import java.util.List;

import com.cristian.design.patterns.models.DwarvenCartOperator;
import com.cristian.design.patterns.models.DwarvenGoldDigger;
import com.cristian.design.patterns.models.DwarvenMineWorker;
import com.cristian.design.patterns.models.DwarvenMineWorker.Action;
import com.cristian.design.patterns.models.DwarvenTunnelDigger;

public class DwarvenGoldmineFacade {

  private final List<DwarvenMineWorker> workers;

  public DwarvenGoldmineFacade() {
    this.workers = List.of(
        new DwarvenGoldDigger(),
        new DwarvenCartOperator(),
        new DwarvenTunnelDigger()
    );
  }

  private void makeActions(final DwarvenMineWorker.Action... actions) {
    this.workers.forEach(worker -> worker.actions(actions));
  }

  public void startNewDay() {
    makeActions(Action.WAKE_UP, Action.GO_TO_MINE);
  }

  public void digOutGold() {
    makeActions(Action.WORK);
  }

  public void endDay() {
    makeActions(Action.GO_HOME, Action.GO_TO_SLEEP);
  }
}
