package com.cristian.design.patterns.db;

import java.util.HashMap;
import java.util.Map;

import com.cristian.design.patterns.models.Account;
import com.cristian.design.patterns.models.Product;
import com.cristian.design.patterns.models.User;

/**
 * Simulate Db
 */
public class Db {

  private static Db instance;

  private final Map<String, User> userNameToUser = new HashMap<>();

  private final Map<User, Account> userToAccount = new HashMap<>();

  private final Map<String, Product> itemNameToProduct = new HashMap<>();

  public static synchronized Db getInstance() {
    if (instance == null) {
      instance = new Db();
    }
    return instance;
  }

  public void seedUser(final String name, final double amount) {
    final User user = new User(name);
    this.userNameToUser.put(name, user);

    final Account account = new Account(amount);
    this.userToAccount.put(user, account);
  }

  public void seedItem(final String name, final double price) {
    final Product item = new Product(price);
    this.itemNameToProduct.put(name, item);
  }

  public User findUserByName(final String name) {
    return this.userNameToUser.getOrDefault(name, null);
  }

  public Account findAccountByUser(final User user) {
    return this.userToAccount.getOrDefault(user, null);
  }

  public Product findProductByItemName(final String name) {
    return this.itemNameToProduct.getOrDefault(name, null);
  }

}
