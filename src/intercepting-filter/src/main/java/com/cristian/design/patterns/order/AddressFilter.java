package com.cristian.design.patterns.order;

import com.cristian.design.patterns.filters.AbstractFilter;

public class AddressFilter extends AbstractFilter {

  @Override
  public String execute(final Order order) {
    final String result = super.execute(order);
    if (order.getAddress() == null || order.getAddress().isEmpty()) {
      return result.concat("Invalid address! ");
    }
    return result;
  }
}
