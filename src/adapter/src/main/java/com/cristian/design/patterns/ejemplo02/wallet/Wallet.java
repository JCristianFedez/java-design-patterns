package com.cristian.design.patterns.ejemplo02.wallet;

import com.cristian.design.patterns.ejemplo02.coin.Dollar;

public class Wallet {

  private final Dollar dollar;

  public Wallet(final Dollar dollar) {
    this.dollar = dollar;
  }

  public double currentMoney() {
    return this.dollar.getQuantity();
  }

}
