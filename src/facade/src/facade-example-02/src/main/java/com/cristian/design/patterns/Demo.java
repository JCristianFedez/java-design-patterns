package com.cristian.design.patterns;

import com.cristian.design.patterns.facade.DwarvenGoldmineFacade;

public class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    final DwarvenGoldmineFacade facade = new DwarvenGoldmineFacade();
    facade.startNewDay();
    System.out.println();

    facade.digOutGold();
    System.out.println();

    facade.endDay();
  }
}
