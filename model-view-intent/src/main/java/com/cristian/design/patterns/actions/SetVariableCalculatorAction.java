package com.cristian.design.patterns.actions;

public record SetVariableCalculatorAction(Double variable) implements CalculatorAction {

  public static final String TAG = "SET_VARIABLE";

  @Override
  public String tag() {
    return TAG;
  }
}
