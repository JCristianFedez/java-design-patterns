package com.cristian.design.patterns;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.cristian.design.patterns.exceptions.BusinessException;

public class FindCustomer implements BusinessOperation<Integer> {

  private final int customerId;

  private final Deque<BusinessException> errors;

  public FindCustomer(final int customerId, final BusinessException... errors) {
    this.customerId = customerId;
    this.errors = new ArrayDeque<>(List.of(errors));
  }

  @Override
  public Integer perform() throws BusinessException {
    if (!this.errors.isEmpty()) {
      throw this.errors.pop();
    }

    return this.customerId;
  }
}
