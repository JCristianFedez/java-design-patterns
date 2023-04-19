package com.cristian.design.patterns;

import com.cristian.design.patterns.application.services.ApplicationServices;
import com.cristian.design.patterns.application.services.ApplicationServicesImpl;
import com.cristian.design.patterns.db.Db;
import com.cristian.design.patterns.db.MaintenanceLock;
import com.cristian.design.patterns.receipts.ReceiptViewModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpecialCaseDemo {

  private static final String LOGGER_STRING = "[REQUEST] User: {} buy product: {}";

  private static final String TEST_USER_1 = "ignite1771";

  private static final String TEST_USER_2 = "abc123";

  private static final String ITEM_TV = "tv";

  private static final String ITEM_CAR = "car";

  private static final String ITEM_COMPUTER = "computer";

  public static void main(String[] args) {
    dbSeeding();

    final ApplicationServices applicationServices = new ApplicationServicesImpl();

    ReceiptViewModel receipt;

    LOGGER.info(LOGGER_STRING, TEST_USER_2, ITEM_TV);
    receipt = applicationServices.loggedInUserPurchase(TEST_USER_2, ITEM_TV);
    receipt.show();
    MaintenanceLock.getInstance().setLock(false);
    LOGGER.info(LOGGER_STRING, TEST_USER_2, ITEM_TV);
    receipt = applicationServices.loggedInUserPurchase(TEST_USER_2, ITEM_TV);
    receipt.show();
    LOGGER.info(LOGGER_STRING, TEST_USER_1, ITEM_TV);
    receipt = applicationServices.loggedInUserPurchase(TEST_USER_1, ITEM_TV);
    receipt.show();
    LOGGER.info(LOGGER_STRING, TEST_USER_1, ITEM_CAR);
    receipt = applicationServices.loggedInUserPurchase(TEST_USER_1, ITEM_CAR);
    receipt.show();
    LOGGER.info(LOGGER_STRING, TEST_USER_1, ITEM_COMPUTER);
    receipt = applicationServices.loggedInUserPurchase(TEST_USER_1, ITEM_COMPUTER);
    receipt.show();
  }

  private static void dbSeeding() {
    LOGGER.info(
        "Db seeding: 1 user: {\"ignite1771\", amount = 1000.0}, 2 products: {\"computer\": price = 800.0, \"car\": price = 20000.0}");
    Db.getInstance().seedUser(TEST_USER_1, 1000.0);
    Db.getInstance().seedItem(ITEM_COMPUTER, 800.0);
    Db.getInstance().seedItem(ITEM_CAR, 20000.0);
  }
}
