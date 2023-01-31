package com.cristian.design.patterns.trees;

import java.awt.Graphics;

public class Tree {
  private final int cordX;
  private final int cordY;
  private final TreeType type;

  public Tree(final int cordX, final int cordY, final TreeType type) {
    this.cordX = cordX;
    this.cordY = cordY;
    this.type = type;
  }

  public void draw(final Graphics graphics) {
    type.draw(graphics, cordX, cordY);
  }
}
