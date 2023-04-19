package com.cristian.design.patterns.filters;

import com.cristian.design.patterns.order.Order;

public class FilterChain {

  private Filter chain;

  public void addFilter(final Filter filter) {
    if (this.chain == null) {
      this.chain = filter;
    } else {
      this.chain.getLast().setNext(filter);
    }
  }

  public String execute(final Order order) {
    if (this.chain != null) {
      return this.chain.execute(order);
    }
    return "RUNNING...";
  }
}
