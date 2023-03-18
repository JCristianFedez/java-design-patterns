package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RegistryDemo {

  public static void main(String[] args) {
    final CustomerRegistry registry = CustomerRegistry.getInstance();
    registry.addCustomer(new Customer(1, "John"));
    registry.addCustomer(new Customer(2, "Julia"));

    LOGGER.info("John {}", registry.getCustomer(1));
    LOGGER.info("Julia {}", registry.getCustomer(2));
  }
}
