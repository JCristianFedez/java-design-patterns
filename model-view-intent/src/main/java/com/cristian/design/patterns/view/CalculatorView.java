package com.cristian.design.patterns.view;

import com.cristian.design.patterns.actions.AdditionCalculatorAction;
import com.cristian.design.patterns.actions.DivisionCalculatorAction;
import com.cristian.design.patterns.actions.MultiplicationCalculatorAction;
import com.cristian.design.patterns.actions.SetVariableCalculatorAction;
import com.cristian.design.patterns.actions.SubtractionCalculatorAction;
import com.cristian.design.patterns.intent.CalculatorViewModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class CalculatorView {

  @Getter
  private final CalculatorViewModel viewModel;

  public void displayTotal() {
    LOGGER.info("Total value = {}", this.viewModel.getModel().toString());
  }

  public void add() {
    this.viewModel.handleAction(new AdditionCalculatorAction());
  }

  public void subtract() {
    this.viewModel.handleAction(new SubtractionCalculatorAction());
  }

  public void multiply() {
    this.viewModel.handleAction(new MultiplicationCalculatorAction());
  }

  public void divide() {
    this.viewModel.handleAction(new DivisionCalculatorAction());
  }

  public void setVariable(final Double value) {
    this.viewModel.handleAction(new SetVariableCalculatorAction(value));
  }
}
