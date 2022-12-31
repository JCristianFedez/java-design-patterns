package com.cristian.design.patterns;

import java.util.Arrays;
import java.util.List;

class Scene {

  private final List<Buffer> frameBuffers;

  private int current;

  private int next;

  public Scene() {
    this.frameBuffers = Arrays.asList(new FrameBuffer(), new FrameBuffer());
    this.current = 0;
    this.next = 1;
  }

  /**
   * Draw the next form.
   */
  public void draw(final List<Coordinate> coordinates) {
    System.out.println("Start drawing next frame");
    System.out.printf("Current buffer: %s, Next buffer: %s%n", this.current, this.next);
    this.frameBuffers.get(this.next).clearAll();
    coordinates.forEach(coordinate -> this.frameBuffers.get(this.next).drawPixel(coordinate));
    System.out.println("Swap current and next buffer");
    swap();
    System.out.println("Finish swapping");
    System.out.printf("Current buffer: %s, Next buffer: %s%n", this.current, this.next);
  }

  public Buffer buffer() {
    System.out.printf("Get current buffer: %s%n", this.current);
    return this.frameBuffers.get(this.current);
  }

  private void swap() {
    this.current = this.current ^ this.next;
    this.next = this.current ^ this.next;
    this.current = this.current ^ this.next;
  }
}
