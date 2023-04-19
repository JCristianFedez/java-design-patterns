package com.cristian.design.patterns;

public class CopperCoin implements Coin {

  private static final String DESCRIPTION = "This is a copper coin.";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
