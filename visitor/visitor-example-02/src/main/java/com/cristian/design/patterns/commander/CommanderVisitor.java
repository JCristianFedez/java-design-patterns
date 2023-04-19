package com.cristian.design.patterns.commander;

import com.cristian.design.patterns.sergeant.Sergeant;
import com.cristian.design.patterns.soldier.Soldier;
import com.cristian.design.patterns.unit.UnitVisitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommanderVisitor implements UnitVisitor {

  /**
   * Soldier Visitor method.
   * @param soldier Soldier to be visited
   */
  @Override
  public void visit(Soldier soldier) {
    // Do nothing
  }

  /**
   * Sergeant Visitor method.
   * @param sergeant Sergeant to be visited
   */
  @Override
  public void visit(Sergeant sergeant) {
    // Do nothing
  }

  /**
   * Commander Visitor method.
   * @param commander Commander to be visited
   */
  @Override
  public void visit(Commander commander) {
    LOGGER.info("Good to see you {}", commander);
  }
}