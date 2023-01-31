package com.cristian.design.patterns.shapes;

import java.util.Objects;

public abstract class Shape {

  private int cordX;

  private int cordY;

  private String color;

  protected Shape() {
  }

  protected Shape(final Shape target) {
    if (target != null) {
      this.cordX = target.cordX;
      this.cordY = target.cordY;
      this.color = target.color;
    }
  }

  public void setCordX(int cordX) {
    this.cordX = cordX;
  }

  public void setCordY(int cordY) {
    this.cordY = cordY;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public abstract Shape clone();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Shape shape)) {
      return false;
    }
    return cordX == shape.cordX && cordY == shape.cordY && Objects.equals(color, shape.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cordX, cordY, color);
  }
}
