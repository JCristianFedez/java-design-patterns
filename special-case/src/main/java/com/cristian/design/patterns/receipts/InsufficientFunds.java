package com.cristian.design.patterns.receipts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record InsufficientFunds(String userName, double amount, String itemName) implements ReceiptViewModel {

  @Override
  public void show() {
    LOGGER.info("Insufficient funds: {} of user: {} for buying item: {}", this.amount, this.userName, this.itemName);
  }
}
