package com.cristian.design.patterns.actions;

public class MultiplicationCalculatorAction implements CalculatorAction {

  public static final String TAG = "MULTIPLICATION";

  @Override
  public String tag() {
    return TAG;
  }
}
