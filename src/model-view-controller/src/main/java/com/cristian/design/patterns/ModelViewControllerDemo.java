package com.cristian.design.patterns;

import com.cristian.design.patterns.controller.GiantController;
import com.cristian.design.patterns.model.Fatigue;
import com.cristian.design.patterns.model.GiantModel;
import com.cristian.design.patterns.model.Health;
import com.cristian.design.patterns.model.Nourishment;
import com.cristian.design.patterns.view.GiantView;

public class ModelViewControllerDemo {

  public static void main(String[] args) {
    new ModelViewControllerDemo().run();
  }

  private void run() {
    final GiantModel giant = new GiantModel(Health.HEALTHY, Fatigue.ALERT, Nourishment.SATURATED);
    final GiantView view = new GiantView();
    final GiantController controller = new GiantController(giant, view);

    controller.updateView();

    controller.setHealth(Health.WOUNDED);
    controller.setNourishment(Nourishment.HUNGRY);
    controller.setFatigue(Fatigue.TIRED);

    controller.updateView();
  }
}
