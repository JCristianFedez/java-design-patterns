package com.cristian.design.patterns.actions;

public class DivisionCalculatorAction implements CalculatorAction {

  public static final String TAG = "DIVISION";

  @Override
  public String tag() {
    return TAG;
  }
}
