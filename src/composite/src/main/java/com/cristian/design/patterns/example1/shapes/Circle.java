package com.cristian.design.patterns.example1.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends BaseShape {

  private final int radius;

  public Circle(int x, int y, Color color, int radius) {
    super(x, y, color);
    this.radius = radius;
  }

  @Override
  public int getWidth() {
    return this.radius * 2;
  }

  @Override
  public int getHeight() {
    return this.radius * 2;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    graphics.drawOval(this.getX(), this.getY(), this.getWidth() - 1, this.getHeight() - 1);
  }
}
