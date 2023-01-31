package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.List;

import com.cristian.design.patterns.shapes.Circle;
import com.cristian.design.patterns.shapes.Rectangle;
import com.cristian.design.patterns.shapes.Shape;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  public static void main(String[] args) {
    final List<Shape> shapes = new ArrayList<>();
    final List<Shape> shapesCopy = new ArrayList<>();

    final Circle circle = new Circle();
    circle.setCordX(10);
    circle.setCordY(20);
    circle.setRadious(15);
    circle.setColor("red");
    shapes.add(circle);

    final Circle anotherCircle = (Circle) circle.clone();
    shapes.add(anotherCircle);

    final Rectangle rectangle = new Rectangle();
    rectangle.setWidth(10);
    rectangle.setHeight(20);
    rectangle.setColor("blue");
    shapes.add(rectangle);

    cloneAndCompare(shapes, shapesCopy);
  }

  private static void cloneAndCompare(final List<Shape> shapes, final List<Shape> shapesCopy) {
    for (Shape shape : shapes) {
      shapesCopy.add(shape.clone());
    }

    for (int i = 0; i < shapes.size(); i++) {
      if (shapes.get(i) != shapesCopy.get(i)) {
        LOGGER.info("{}: Shape different objects (yay!)", i);
        if (shapes.get(i).equals(shapesCopy.get(i))) {
          LOGGER.info("{}: : And they are identical (yay!)", i);
        } else {
          LOGGER.info("{}: But they are not identical (booo!)", i);
        }
      } else {
        LOGGER.info("{}: Shape objects are the same (booo!)", i);
      }
    }
  }
}
