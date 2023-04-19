package com.cristian.design.patterns.order;

import com.cristian.design.patterns.filters.AbstractFilter;

public class OrderFilter extends AbstractFilter {

  @Override
  public String execute(final Order order) {
    final String result = super.execute(order);
    if (order.getOrderItem() == null || order.getOrderItem().isEmpty()) {
      return result.concat("Invalid order! ");
    }
    return result;
  }
}
