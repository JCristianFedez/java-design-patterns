package com.cristian.design.patterns.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.cristian.design.patterns.shapes.Circle;
import com.cristian.design.patterns.shapes.Rectangle;
import com.cristian.design.patterns.shapes.Shape;

public class BundledShapeCache {

  private final ConcurrentMap<String, Shape> cache = new ConcurrentHashMap<>();

  public BundledShapeCache() {
    this.loadDefaultCache();
  }

  public Shape put(final String key, final Shape shape) {
    this.cache.put(key, shape);
    return shape;
  }

  public Shape get(final String key) {
    return this.cache.get(key).clone();
  }

  private void loadDefaultCache() {
    final Circle circle = new Circle();
    circle.setCordX(5);
    circle.setCordY(7);
    circle.setRadious(45);
    circle.setColor("Green");

    final Rectangle rectangle = new Rectangle();
    rectangle.setCordX(6);
    rectangle.setCordY(9);
    rectangle.setWidth(8);
    rectangle.setHeight(10);
    rectangle.setColor("Blue");

    cache.put("Big green circle", circle);
    cache.put("Medium blue rectangle", rectangle);
  }

}
