package com.cristian.design.patterns;

/**
 * The Rect class helps in defining the boundary of the quadtree and is also used to define the range within which objects need to be found
 * in our example.
 */
public record Rect(double coordinateX, double coordinateY, double width, double height) {

  boolean contains(final Point<?> point) {
    return point.getCoordinateX() >= this.coordinateX - this.width / 2
        && point.getCoordinateX() <= this.coordinateX + this.width / 2
        && point.getCoordinateY() >= this.coordinateY - this.height / 2
        && point.getCoordinateY() <= this.coordinateY + this.height / 2;
  }

  boolean intersects(final Rect other) {
    return !(this.coordinateX + this.width / 2 <= other.coordinateX - other.width / 2
        || this.coordinateX - this.width / 2 >= other.coordinateX + other.width / 2
        || this.coordinateY + this.height / 2 <= other.coordinateY - other.height / 2
        || this.coordinateY - this.height / 2 >= other.coordinateY + other.height / 2);
  }
}
