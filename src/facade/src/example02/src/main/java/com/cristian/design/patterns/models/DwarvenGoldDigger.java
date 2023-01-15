package com.cristian.design.patterns.models;

public class DwarvenGoldDigger extends DwarvenMineWorker {

  @Override
  public String name() {
    return "Dwarf gold digger";
  }

  @Override
  public void work() {
    System.out.printf("%s digs for gold.%n", name());
  }
}
