package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;

class Demo {

  public static void main(String[] args) {
    new Demo().run();
  }

  private void run() {
    final Scene scene = new Scene();
    final List<Coordinate> drawPixels1 = Arrays.asList(
        new Coordinate(1, 1),
        new Coordinate(5, 6),
        new Coordinate(3, 2)
    );
    scene.draw(drawPixels1);
    final Buffer buffer1 = scene.buffer();
    printBlackPixelCoordinate(buffer1);

    final List<Coordinate> drawPixels2 = Arrays.asList(
        new Coordinate(3, 7),
        new Coordinate(6, 1),
        new Coordinate(3, 2)
    );
    scene.draw(drawPixels2);
    final Buffer buffer2 = scene.buffer();
    printBlackPixelCoordinate(buffer2);
  }

  private void printBlackPixelCoordinate(final Buffer buffer) {
    final StringBuilder sb = new StringBuilder("Black Pixels: ");
    final List<Pixel> pixels = buffer.pixels();
    for (int i = 0; i < pixels.size(); i++) {
      if (Pixel.BLACK.equals(pixels.get(i))) {
        final int cordY = i / FrameBuffer.WIDTH;
        final int cordX = i % FrameBuffer.WIDTH;
        sb.append(" (").append(cordX).append(", ").append(cordY).append(")");
      }
    }
    System.out.println(sb);
  }
}
