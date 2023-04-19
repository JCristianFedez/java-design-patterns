package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FrameBuffer implements Buffer {

  public static final int WIDTH = 10;

  public static final int HEIGHT = 8;

  private final List<Pixel> pixels = new ArrayList<>(Collections.nCopies(WIDTH * HEIGHT, Pixel.WHITE));

  @Override
  public void clearPixel(final Coordinate coordinate) {
    this.pixels.set(index(coordinate), Pixel.WHITE);
  }

  @Override
  public void drawPixel(final Coordinate coordinate) {
    this.pixels.set(index(coordinate), Pixel.BLACK);
  }

  @Override
  public void clearAll() {
    Collections.fill(this.pixels, Pixel.WHITE);
  }

  @Override
  public List<Pixel> pixels() {
    return this.pixels;
  }

  private int index(final Coordinate coordinate) {
    return coordinate.getCordX() + WIDTH * coordinate.getCordY();
  }
}
