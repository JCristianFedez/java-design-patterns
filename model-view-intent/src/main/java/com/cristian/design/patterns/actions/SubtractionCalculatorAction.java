package com.cristian.design.patterns.actions;

public class SubtractionCalculatorAction implements CalculatorAction {

  public static final String TAG = "SUBSTRACTION";

  @Override
  public String tag() {
    return TAG;
  }
}
