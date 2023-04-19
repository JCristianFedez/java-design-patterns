package com.cristian.design.patterns.receipts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DownForMaintenance implements ReceiptViewModel {

  @Override
  public void show() {
    LOGGER.info("Down for maintenance");
  }
}
