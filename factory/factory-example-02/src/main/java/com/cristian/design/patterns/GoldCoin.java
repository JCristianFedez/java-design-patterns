package com.cristian.design.patterns;

public class GoldCoin implements Coin {

  private static final String DESCRIPTION = "This is a golden coin.";

  @Override
  public String getDescription() {
    return DESCRIPTION;
  }
}
