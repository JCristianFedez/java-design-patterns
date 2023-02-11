package com.cristian.design.patterns.filters;

import java.util.Optional;

import com.cristian.design.patterns.order.Order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractFilter implements Filter {

  private Filter next;

  @Override
  public String execute(final Order order) {
    return Optional.ofNullable(getNext())
        .map(filter -> filter.execute(order))
        .orElse("");
  }

  @Override
  public Filter getLast() {
    return getNext() == null ? this : getNext().getLast();
  }
}
