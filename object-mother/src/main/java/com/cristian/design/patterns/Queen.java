package com.cristian.design.patterns;

import lombok.Getter;

@Getter
public class Queen implements Royalty {

  private boolean isDrunk = false;

  private boolean isHappy = false;

  private boolean isFlirty = false;

  @Override
  public void makeDrunk() {
    this.isDrunk = true;
  }

  @Override
  public void makeSober() {
    this.isDrunk = false;
  }

  @Override
  public void makeHappy() {
    this.isHappy = true;
  }

  @Override
  public void makeUnhappy() {
    this.isHappy = false;
  }

  public void setFlirtiness(boolean flirtiness) {
    this.isFlirty = flirtiness;
  }

  public boolean isFlirtedSuccessful(final King king) {
    return this.isFlirty && king.isHappy() && !king.isDrunk();
  }
}
