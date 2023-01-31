package com.cristian.design.patterns.models;

public class DwarvenCartOperator extends DwarvenMineWorker {

  @Override
  public String name() {
    return "Dwarf cart operator";
  }

  @Override
  public void work() {
    System.out.printf("{} moves gold chunks out of the mine.%n", name());
  }
}
