package com.cristian.design.patterns.domain.services;

import com.cristian.design.patterns.db.Db;
import com.cristian.design.patterns.models.Account;
import com.cristian.design.patterns.models.MoneyTransaction;
import com.cristian.design.patterns.models.Product;
import com.cristian.design.patterns.models.User;
import com.cristian.design.patterns.receipts.InsufficientFunds;
import com.cristian.design.patterns.receipts.InvalidUser;
import com.cristian.design.patterns.receipts.OutOfStock;
import com.cristian.design.patterns.receipts.ReceiptDto;
import com.cristian.design.patterns.receipts.ReceiptViewModel;

public class DomainServicesImpl implements DomainServices {

  @Override
  public ReceiptViewModel purchase(final String userName, final String itemName) {
    final User user = Db.getInstance().findUserByName(userName);
    if (user == null) {
      return new InvalidUser(userName);
    }
    final Account account = Db.getInstance().findAccountByUser(user);
    return purchase(user, account, itemName);
  }

  /**
   * Domain purchase with user, account and itemName, with validation for whether product is out of stock and whether user has insufficient
   * funds in the account.
   */
  private ReceiptViewModel purchase(final User user, final Account account, final String itemName) {
    final Product item = Db.getInstance().findProductByItemName(itemName);
    if (item == null) {
      return new OutOfStock(user.name(), itemName);
    }
    final ReceiptDto receiptDto = user.purchase(item);
    final MoneyTransaction transaction = account.withdraw(receiptDto.price());
    if (transaction == null) {
      return new InsufficientFunds(user.name(), account.amount(), itemName);
    }

    return receiptDto;
  }
}
