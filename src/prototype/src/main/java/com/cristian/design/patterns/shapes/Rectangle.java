package com.cristian.design.patterns.shapes;

import java.util.Objects;

public class Rectangle extends Shape {

  private int width;

  private int height;

  public Rectangle() {
  }

  public Rectangle(final Rectangle target) {
    super(target);
    if (target != null) {
      this.width = target.width;
      this.height = target.height;
    }
  }

  @Override
  public Shape clone() {
    return new Rectangle(this);
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rectangle rectangle)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    return width == rectangle.width && height == rectangle.height;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), width, height);
  }
}
