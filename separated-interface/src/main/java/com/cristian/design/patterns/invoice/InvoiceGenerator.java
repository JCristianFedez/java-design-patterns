package com.cristian.design.patterns.invoice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceGenerator {

  private final TaxCalculator taxCalculator;

  private final double amount;

  public double amountWithTax() {
    return this.amount + this.taxCalculator.calculate(this.amount);
  }
}
