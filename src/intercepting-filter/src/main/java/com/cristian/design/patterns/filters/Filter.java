package com.cristian.design.patterns.filters;

import com.cristian.design.patterns.order.Order;

public interface Filter {

  String execute(Order order);

  Filter getNext();

  void setNext(Filter filter);

  Filter getLast();
}
