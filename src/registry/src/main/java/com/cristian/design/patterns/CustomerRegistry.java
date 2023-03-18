package com.cristian.design.patterns;

import java.util.HashMap;
import java.util.Map;

public class CustomerRegistry {

  private static final CustomerRegistry INSTANCE = new CustomerRegistry();

  private final Map<Integer, Customer> customerMap = new HashMap<>();

  private CustomerRegistry() {
  }

  public static CustomerRegistry getInstance() {
    return INSTANCE;
  }

  public Customer addCustomer(final Customer customer) {
    return this.customerMap.put(customer.id(), customer);
  }

  public Customer getCustomer(final int id) {
    return this.customerMap.get(id);
  }
}
