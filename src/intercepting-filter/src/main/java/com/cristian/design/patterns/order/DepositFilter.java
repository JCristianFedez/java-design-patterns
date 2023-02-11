package com.cristian.design.patterns.order;

import com.cristian.design.patterns.filters.AbstractFilter;

public class DepositFilter extends AbstractFilter {

  @Override
  public String execute(final Order order) {
    final String result = super.execute(order);
    if (order.getDepositNumber() == null || order.getDepositNumber().isEmpty()) {
      return result.concat("Invalid deposit number! ");
    }
    return result;
  }
}
