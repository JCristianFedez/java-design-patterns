package com.cristian.design.patterns.receipts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record OutOfStock(String userName, String itemName) implements ReceiptViewModel {

  @Override
  public void show() {
    LOGGER.info("Out of stock: {} for user = {} to buy", this.itemName, this.userName);
  }
}
