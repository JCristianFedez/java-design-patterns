package com.cristian.design.patterns;

import java.util.List;

interface Buffer {

  void clearPixel(Coordinate coordinate);

  void drawPixel(Coordinate coordinate);

  void clearAll();

  List<Pixel> pixels();
}
