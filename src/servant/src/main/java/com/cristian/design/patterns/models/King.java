package com.cristian.design.patterns.models;

public class King implements Royalty {

  private boolean isDrunk;

  private boolean isHungry = true;

  private boolean isHappy;

  private boolean complimentReceived;

  @Override
  public void getFed() {
    this.isHungry = false;
  }

  @Override
  public void getDrink() {
    this.isDrunk = true;
  }

  @Override
  public void changeMood() {
    if (!this.isHungry && this.isDrunk) {
      this.isHappy = true;
    }
    if (this.complimentReceived) {
      this.isHappy = false;
    }
  }

  @Override
  public void receiveCompliments() {
    this.complimentReceived = true;
  }

  @Override
  public boolean getMood() {
    return this.isHappy;
  }
}
