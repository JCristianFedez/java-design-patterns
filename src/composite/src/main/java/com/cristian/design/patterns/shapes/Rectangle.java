package com.cristian.design.patterns.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends BaseShape {

  private final int width;

  private final int height;

  public Rectangle(int x, int y, Color color, int width, int height) {
    super(x, y, color);
    this.width = width;
    this.height = height;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    graphics.drawRect(this.getX(), this.getY(), this.getWidth() - 1, this.getHeight() - 1);
  }
}
