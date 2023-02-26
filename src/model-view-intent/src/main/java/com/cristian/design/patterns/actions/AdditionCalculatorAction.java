package com.cristian.design.patterns.actions;

public class AdditionCalculatorAction implements CalculatorAction {

  public static final String TAG = "ADDITION";

  @Override
  public String tag() {
    return TAG;
  }
}
