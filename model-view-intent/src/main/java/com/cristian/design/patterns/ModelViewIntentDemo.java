package com.cristian.design.patterns;

import com.cristian.design.patterns.intent.CalculatorViewModel;
import com.cristian.design.patterns.view.CalculatorView;

public class ModelViewIntentDemo {

  public static void main(String[] args) {
    new ModelViewIntentDemo().run();
  }

  private void run() {
    final CalculatorView view = new CalculatorView(new CalculatorViewModel());

    view.setVariable(10.0);

    view.add();
    view.displayTotal();

    view.setVariable(2.0);

    view.subtract();

    view.divide();

    view.multiply();
    view.displayTotal();
  }
}
