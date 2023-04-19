package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
public class Account {

  private final int id;

  private int amount;

  public void addAmount(final int amountToAdd) {
    this.amount += amountToAdd;
  }

  public void retireAmount(final int amountToRetire) {
    this.amount -= amountToRetire;
  }

}
