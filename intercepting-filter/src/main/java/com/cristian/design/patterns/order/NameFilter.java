package com.cristian.design.patterns.order;

import com.cristian.design.patterns.filters.AbstractFilter;

public class NameFilter extends AbstractFilter {

  @Override
  public String execute(final Order order) {
    final String result = super.execute(order);
    if (order.getName() == null || order.getName().isEmpty()) {
      return result.concat("Invalid name! ");
    }
    return result;
  }
}
