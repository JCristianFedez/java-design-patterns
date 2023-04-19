package com.cristian.design.patterns.order;

import com.cristian.design.patterns.filters.AbstractFilter;

public class ContactFilter extends AbstractFilter {

  @Override
  public String execute(final Order order) {
    final String result = super.execute(order);
    if (order.getContactNumber() == null || order.getContactNumber().isEmpty()) {
      return result.concat("Invalid contact! ");
    }
    return result;
  }
}
