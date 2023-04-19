package com.cristian.design.patterns;

import com.cristian.design.patterns.controllers.GiantController;
import com.cristian.design.patterns.models.Fatigue;
import com.cristian.design.patterns.models.GiantModel;
import com.cristian.design.patterns.models.Health;
import com.cristian.design.patterns.models.Nourishment;
import com.cristian.design.patterns.views.GiantView;

public class ServiceToWorkerDemo {

  public static void main(String[] args) {
    final GiantModel giant1 = new GiantModel("giant1", Health.HEALTHY, Fatigue.ALERT, Nourishment.SATURATED);
    final GiantModel giant2 = new GiantModel("giant2", Health.DEAD, Fatigue.SLEEPING, Nourishment.STARVING);

    final Dispatcher dispatcher = new Dispatcher(new GiantView());
    dispatcher.addAction(new Action(giant1));
    dispatcher.addAction(new Action(giant2));

    final GiantController controller = new GiantController(dispatcher);

    // Initial display
    controller.updateView(giant1);
    controller.updateView(giant2);

    // Controller receives some interactions that affect the giant
    controller.setCommand(new Command(Fatigue.SLEEPING, Health.HEALTHY, Nourishment.STARVING), 0);
    controller.setCommand(new Command(Fatigue.ALERT, Health.HEALTHY, Nourishment.HUNGRY), 1);

    // Redisplay
    controller.updateView(giant1);
    controller.updateView(giant2);
  }
}
