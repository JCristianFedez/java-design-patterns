package com.cristian.design.patterns.receipts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public record InvalidUser(String user) implements ReceiptViewModel {

  @Override
  public void show() {
    LOGGER.info("Invalid user: {}", this.user);
  }
}
