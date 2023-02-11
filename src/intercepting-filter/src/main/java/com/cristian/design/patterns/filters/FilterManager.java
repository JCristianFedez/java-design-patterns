package com.cristian.design.patterns.filters;

import com.cristian.design.patterns.order.Order;

public class FilterManager {

  private final FilterChain filterChain;

  public FilterManager() {
    this.filterChain = new FilterChain();
  }

  public void addFilter(final Filter filter) {
    this.filterChain.addFilter(filter);
  }

  public String filterRequest(final Order order) {
    return this.filterChain.execute(order);
  }
}
