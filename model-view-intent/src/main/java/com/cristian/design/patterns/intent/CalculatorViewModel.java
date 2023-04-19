package com.cristian.design.patterns.intent;

import com.cristian.design.patterns.actions.AdditionCalculatorAction;
import com.cristian.design.patterns.actions.CalculatorAction;
import com.cristian.design.patterns.actions.DivisionCalculatorAction;
import com.cristian.design.patterns.actions.MultiplicationCalculatorAction;
import com.cristian.design.patterns.actions.SetVariableCalculatorAction;
import com.cristian.design.patterns.actions.SubtractionCalculatorAction;
import com.cristian.design.patterns.model.CalculatorModel;

import lombok.Getter;

public class CalculatorViewModel {

  @Getter
  private final CalculatorModel model = new CalculatorModel(0.0, 0.0);

  private void setVariable(final Double variable) {
    this.model.setVariable(variable);
  }

  public void handleAction(final CalculatorAction action) {
    switch (action.tag()) {
      case AdditionCalculatorAction.TAG -> add();
      case SubtractionCalculatorAction.TAG -> subtract();
      case MultiplicationCalculatorAction.TAG -> multiply();
      case DivisionCalculatorAction.TAG -> divide();
      case SetVariableCalculatorAction.TAG -> {
        final SetVariableCalculatorAction setVariableAction = (SetVariableCalculatorAction) action;
        setVariable(setVariableAction.variable());
      }
      default -> throw new UnsupportedOperationException();
    }
  }

  private void add() {
    final double newOutput = this.model.getOutput() + this.model.getVariable();
    this.model.setOutput(newOutput);
  }

  private void subtract() {
    final double newOutput = this.model.getOutput() - this.model.getVariable();
    this.model.setOutput(newOutput);
  }

  private void multiply() {
    final double newOutput = this.model.getOutput() * this.model.getVariable();
    this.model.setOutput(newOutput);
  }

  private void divide() {
    final double newOutput = this.model.getOutput() / this.model.getVariable();
    this.model.setOutput(newOutput);
  }
}
