package com.cristian.design.patterns;

import com.cristian.design.patterns.invoice.InvoiceGenerator;
import com.cristian.design.patterns.taxes.DomesticTaxCalculator;
import com.cristian.design.patterns.taxes.ForeignTaxCalculator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SeparatedInterfaceDemo {

  private static final double PRODUCT_COST = 50;

  public static void main(String[] args) {
    final InvoiceGenerator internationalProductInvoice = new InvoiceGenerator(new ForeignTaxCalculator(), PRODUCT_COST);
    LOGGER.info("Foreign Tax applied: {}", internationalProductInvoice.amountWithTax());

    final InvoiceGenerator domesticProductInvoice = new InvoiceGenerator(new DomesticTaxCalculator(), PRODUCT_COST);
    LOGGER.info("Domestic Tax applied: {}", domesticProductInvoice.amountWithTax());
  }
}
