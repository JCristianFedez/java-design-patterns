package com.cristian.design.patterns;

public class CoinFactory {

  public static Coin getCoin(final CoinType type) {
    return type.getConstructor().get();
  }
}
