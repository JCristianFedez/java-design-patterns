package com.cristian.design.patterns;

public class FrontControllerDemo {

  public static void main(String[] args) {
    new FrontControllerDemo().run();
  }

  private void run() {
    final FrontController controller = new FrontController();
    controller.handleRequest("Archer");
    controller.handleRequest("Catapult");
    controller.handleRequest("foobar");
  }
}
