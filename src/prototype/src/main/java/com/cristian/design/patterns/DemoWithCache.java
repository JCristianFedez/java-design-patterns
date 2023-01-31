package com.cristian.design.patterns;

import com.cristian.design.patterns.cache.BundledShapeCache;
import com.cristian.design.patterns.shapes.Shape;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoWithCache {

  public static void main(String[] args) {
    final BundledShapeCache cache = new BundledShapeCache();

    final Shape shape1 = cache.get("Big green circle");
    final Shape shape2 = cache.get("Medium blue rectangle");
    final Shape shape3 = cache.get("Medium blue rectangle");

    if (shape1 != shape2 && !shape1.equals(shape2)) {
      LOGGER.info("Big green circle != Medium blue rectangle (yay!)");
    } else {
      LOGGER.info("Big green circle == Medium blue rectangle (booo!)");
    }

    if (shape2 != shape3) {
      LOGGER.info("Medium blue rectangles are two different objects (yay!)");
      if (shape2.equals(shape3)) {
        LOGGER.info("And they are identical (yay!)");
      } else {
        LOGGER.info("But they are not identical (booo!)");
      }
    } else {
      LOGGER.info("Rectangle objects are the same (booo!)");
    }
  }
}
