package com.cristian.design.patterns.soldier;

import com.cristian.design.patterns.commander.Commander;
import com.cristian.design.patterns.sergeant.Sergeant;
import com.cristian.design.patterns.unit.UnitVisitor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoldierVisitor implements UnitVisitor {

  /**
   * Soldier Visitor method.
   * @param soldier Soldier to be visited
   */
  @Override
  public void visit(Soldier soldier) {
    LOGGER.info("Greetings {}", soldier);
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
    // Do nothing
  }
}