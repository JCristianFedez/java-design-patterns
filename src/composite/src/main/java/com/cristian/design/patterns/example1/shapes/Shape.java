package com.cristian.design.patterns.example1.shapes;

import java.awt.Graphics;

public interface Shape {

  int getCordX();

  int getCordY();

  int getWidth();

  int getHeight();

  void move(int x, int y);

  boolean isInsideBounds(int x, int y);

  void select();

  void unSelect();

  boolean isSelected();

  void paint(Graphics graphics);
}
