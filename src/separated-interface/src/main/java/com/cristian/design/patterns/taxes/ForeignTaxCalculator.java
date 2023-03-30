package com.cristian.design.patterns.taxes;

import com.cristian.design.patterns.invoice.TaxCalculator;

public class ForeignTaxCalculator implements TaxCalculator {

  private static final double TAX_PERCENTAGE = 60;

  @Override
  public double calculate(final double amount) {
    return amount * (TAX_PERCENTAGE / 100);
  }
}
