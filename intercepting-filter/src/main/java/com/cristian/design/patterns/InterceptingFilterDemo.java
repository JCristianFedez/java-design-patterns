package com.cristian.design.patterns;

import com.cristian.design.patterns.filters.FilterManager;
import com.cristian.design.patterns.order.AddressFilter;
import com.cristian.design.patterns.order.ContactFilter;
import com.cristian.design.patterns.order.DepositFilter;
import com.cristian.design.patterns.order.NameFilter;
import com.cristian.design.patterns.order.OrderFilter;

public class InterceptingFilterDemo {

  public static void main(String[] args) {
    new InterceptingFilterDemo().run();
  }

  private void run() {
    final FilterManager filterManager = new FilterManager();
    filterManager.addFilter(new NameFilter());
    filterManager.addFilter(new ContactFilter());
    filterManager.addFilter(new AddressFilter());
    filterManager.addFilter(new DepositFilter());
    filterManager.addFilter(new OrderFilter());

    final Client client = new Client();
    client.setFilterManager(filterManager);
  }
}
