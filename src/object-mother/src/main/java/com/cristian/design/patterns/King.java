package com.cristian.design.patterns;

import lombok.Getter;

@Getter
public class King implements Royalty {

  private boolean isDrunk;

  private boolean isHappy;

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

  public void flirt(final Queen queen) {
    final boolean flirtStatus = queen.isFlirtedSuccessful(this);
    if (!flirtStatus) {
      makeUnhappy();
    } else {
      makeHappy();
    }
  }
}
