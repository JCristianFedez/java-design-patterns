package com.cristian.design.patterns.example2;

class Demo {

  public static void main(String[] args) {
    System.out.println("A simple looking troll approaches.");
    final SimpleTroll troll = new SimpleTroll();
    troll.attack();
    troll.fleeBattle();
    System.out.printf("Simple troll power: {}%n", troll.attackPower());

    System.out.println("A troll with huge club surprise you");
    final ClubbedTroll clubbedTroll = new ClubbedTroll(troll);
    clubbedTroll.attack();
    clubbedTroll.fleeBattle();
    System.out.printf("Clubbed troll power: {}%n", clubbedTroll.attackPower());
  }
}
