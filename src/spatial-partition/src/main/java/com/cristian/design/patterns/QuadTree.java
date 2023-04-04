package com.cristian.design.patterns;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

// TODO: 2/4/23 Refactorizar
public class QuadTree<T> {

  private final Rect boundary;

  private final int capacity;

  private boolean divided;

  private final Map<Integer, Point<T>> points = new Hashtable<>();

  private QuadTree<T> northwest;

  private QuadTree<T> northeast;

  private QuadTree<T> southwest;

  private QuadTree<T> southeast;

  public QuadTree(Rect boundary, int capacity) {
    this.boundary = boundary;
    this.capacity = capacity;
  }

  public void insert(final Point<T> point) {
    if (this.boundary.contains(point)) {
      if (this.points.size() < this.capacity) {
        points.put(point.getId(), point);
      } else {
        if (!this.divided) {
          this.divide();
        }
        if (this.northwest.boundary.contains(point)) {
          this.northwest.insert(point);
        } else if (this.northeast.boundary.contains(point)) {
          this.northeast.insert(point);
        } else if (this.southwest.boundary.contains(point)) {
          this.southwest.insert(point);
        } else if (this.southeast.boundary.contains(point)) {
          this.southeast.insert(point);
        }
      }
    }
  }

  private void divide() {
    final double x = this.boundary.coordinateX();
    final double y = this.boundary.coordinateY();
    final double width = this.boundary.width();
    final double height = this.boundary.height();
    final Rect nw = new Rect(x - width / 4, y + height / 4, width / 2, height / 2);
    this.northwest = new QuadTree<>(nw, this.capacity);
    final Rect ne = new Rect(x + width / 4, y + height / 4, width / 2, height / 2);
    this.northeast = new QuadTree<>(ne, this.capacity);
    final Rect sw = new Rect(x - width / 4, y - height / 4, width / 2, height / 2);
    this.southwest = new QuadTree<>(sw, this.capacity);
    final Rect se = new Rect(x + width / 4, y - height / 4, width / 2, height / 2);
    this.southeast = new QuadTree<>(se, this.capacity);
    this.divided = true;
  }

  public Collection<Point<T>> query(final Rect rect, final Collection<Point<T>> relevantPoints) {
    //could also be a circle instead of a rectangle
    if (this.boundary.intersects(rect)) {
      this.points
          .values()
          .stream()
          .filter(rect::contains)
          .forEach(relevantPoints::add);
      if (this.divided) {
        this.northwest.query(rect, relevantPoints);
        this.northeast.query(rect, relevantPoints);
        this.southwest.query(rect, relevantPoints);
        this.southeast.query(rect, relevantPoints);
      }
    }
    return relevantPoints;
  }
}
