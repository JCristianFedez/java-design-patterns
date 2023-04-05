package com.cristian.design.patterns.application.services;

import com.cristian.design.patterns.db.MaintenanceLock;
import com.cristian.design.patterns.domain.services.DomainServices;
import com.cristian.design.patterns.domain.services.DomainServicesImpl;
import com.cristian.design.patterns.receipts.DownForMaintenance;
import com.cristian.design.patterns.receipts.ReceiptViewModel;

public class ApplicationServicesImpl implements ApplicationServices {

  private final DomainServices domain = new DomainServicesImpl();

  @Override
  public ReceiptViewModel loggedInUserPurchase(final String userName, final String itemName) {
    if (isDownForMaintenance()) {
      return new DownForMaintenance();
    }
    return this.domain.purchase(userName, itemName);
  }

  private boolean isDownForMaintenance() {
    return MaintenanceLock.getInstance().isLock();
  }
}
