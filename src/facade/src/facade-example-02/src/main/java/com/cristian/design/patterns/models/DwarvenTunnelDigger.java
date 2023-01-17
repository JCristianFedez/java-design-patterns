package com.cristian.design.patterns.models;

public class DwarvenTunnelDigger extends DwarvenMineWorker {

  @Override
  public String name() {
    return "Dwarven tunnel digger";
  }

  @Override
  public void work() {
    System.out.printf("%s creates another promising tunnel.%n", name());
  }
}
