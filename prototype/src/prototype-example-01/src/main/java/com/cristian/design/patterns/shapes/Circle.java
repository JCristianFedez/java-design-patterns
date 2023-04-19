package com.cristian.design.patterns.shapes;

import java.util.Objects;

public class Circle extends Shape {

  private int radious;

  public Circle() {
  }

  public Circle(final Circle target) {
    super(target);
    if (target != null) {
      this.radious = target.radious;
    }
  }

  public void setRadious(int radious) {
    this.radious = radious;
  }

  public Shape clone() {
    return new Circle(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Circle circle)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    return radious == circle.radious;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), radious);
  }
}
