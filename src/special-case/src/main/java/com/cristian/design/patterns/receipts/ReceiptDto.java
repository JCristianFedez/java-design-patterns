package com.cristian.design.patterns.receipts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record ReceiptDto(double price) implements ReceiptViewModel {

  @Override
  public void show() {
    LOGGER.info("Receipt: {} paid", this.price);
  }
}
