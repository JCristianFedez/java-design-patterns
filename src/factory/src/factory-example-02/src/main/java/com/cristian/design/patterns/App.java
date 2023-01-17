package com.cristian.design.patterns;

public class App {

  public static void main(String[] args) {
    new App().run();
  }

  private void run() {
    System.out.println("The alchemist begins his work.");

    final Coin copperCoin = CoinFactory.getCoin(CoinType.COPPER);
    final Coin goldCoin = CoinFactory.getCoin(CoinType.GOLD);

    System.out.println(copperCoin.getDescription());
    System.out.println(goldCoin.getDescription());
  }
}
