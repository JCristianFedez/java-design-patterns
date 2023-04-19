package com.cristian.design.patterns.example1.shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Dot extends BaseShape {

  private static final int DOT_SIZE = 3;

  public Dot(int x, int y, Color color) {
    super(x, y, color);
  }

  @Override
  public int getWidth() {
    return DOT_SIZE;
  }

  @Override
  public int getHeight() {
    return DOT_SIZE;
  }

  @Override
  public void paint(Graphics graphics) {
    super.paint(graphics);
    graphics.fillRect(this.getCordX() - 1, this.getCordY() - 1, this.getWidth(), this.getHeight());
  }
}
