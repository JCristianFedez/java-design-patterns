package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;

class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  private static void collisionChecks(final List<GameObject> objects) {
    objects.forEach(o1 -> objects.forEach(o2 -> {
      if (o1 != o2 && o1.intersectsWith(o2)) {
        o1.collision(o2);
      }
    }));
    System.out.println();
  }

  private void run() {
    final List<GameObject> objects = initializeGameObjects();
    collisionChecks(objects);
    printGameObjects(objects);
    System.exit(0);
  }

  private static void printGameObjects(final List<GameObject> objects) {
    objects.stream().map(GameObject::toString).forEach(System.out::println);
    System.out.println();
  }

  private static List<GameObject> initializeGameObjects() {
    final List<GameObject> objects = Arrays.asList(
        new FlamingAsteroid(0, 0, 5, 5),
        new SpaceStationMir(1, 1, 2, 2),
        new Meteoroid(10, 10, 15, 15),
        new SpaceStationIss(12, 12, 14, 14)
    );
    printGameObjects(objects);
    return objects;
  }
}
