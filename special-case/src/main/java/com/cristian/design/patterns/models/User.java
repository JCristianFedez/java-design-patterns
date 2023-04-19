package com.cristian.design.patterns.models;

import com.cristian.design.patterns.receipts.ReceiptDto;

public record User(String name) {

  public ReceiptDto purchase(final Product item) {
    return new ReceiptDto(item.price());
  }
}
