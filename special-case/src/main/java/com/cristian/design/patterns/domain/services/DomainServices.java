package com.cristian.design.patterns.domain.services;

import com.cristian.design.patterns.receipts.ReceiptViewModel;

public interface DomainServices {

  /**
   * Domain purchase with userName and itemName, with validation for userName.
   */
  ReceiptViewModel purchase(String userName, String itemName);
}
