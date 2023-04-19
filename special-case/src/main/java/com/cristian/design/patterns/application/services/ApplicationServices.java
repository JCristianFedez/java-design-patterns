package com.cristian.design.patterns.application.services;

import com.cristian.design.patterns.receipts.ReceiptViewModel;

public interface ApplicationServices {

  ReceiptViewModel loggedInUserPurchase(String userName, String itemName);
}
