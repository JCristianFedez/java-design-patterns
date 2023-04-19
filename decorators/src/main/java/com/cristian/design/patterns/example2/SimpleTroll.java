package com.cristian.design.patterns.example2;

class SimpleTroll implements Troll {

  @Override
  public void attack() {
    System.out.println("The troll tries to grab you!");
  }

  @Override
  public int attackPower() {
    return 10;
  }

  @Override
  public void fleeBattle() {
    System.out.println("The troll shrieks in horror and run away!");
  }
}
