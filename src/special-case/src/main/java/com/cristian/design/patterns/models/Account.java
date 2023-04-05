package com.cristian.design.patterns.models;

public record Account(double amount) {

  /**
   * Withdraw the price of the item from the account.
   *
   * @param price of the item
   * @return instance of MoneyTransaction
   */
  public MoneyTransaction withdraw(Double price) {
    if (price > this.amount) {
      return null;
    }
    return new MoneyTransaction(this.amount, price);
  }
}
