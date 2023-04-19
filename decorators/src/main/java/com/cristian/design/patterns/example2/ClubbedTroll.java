package com.cristian.design.patterns.example2;

class ClubbedTroll implements Troll {

  private final Troll decorated;

  public ClubbedTroll(final Troll decorated) {
    this.decorated = decorated;
  }

  @Override
  public void attack() {
    this.decorated.attack();
    System.out.println("The troll swings at you with a club!");
  }

  @Override
  public int attackPower() {
    return this.decorated.attackPower() + 10;
  }

  @Override
  public void fleeBattle() {
    this.decorated.fleeBattle();
  }
}
