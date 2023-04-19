package com.cristian.design.patterns;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public class RainbowFishSerializer {

  private static final String LENGTH_METERS = "lengthMeters";

  private static final String WEIGHT_TONS = "weightTons";

  private RainbowFishSerializer() {
  }

  public static void writeV1(RainbowFish rainbowFish, String filename) throws IOException {
    final Map<String, String> map = Map.of(
        "name", rainbowFish.getName(),
        "age", String.format("%d", rainbowFish.getAge()),
        LENGTH_METERS, String.format("%d", rainbowFish.getLength()),
        WEIGHT_TONS, String.format("%d", rainbowFish.getWeight())
    );

    try (final FileOutputStream fileOut = new FileOutputStream(filename);
        final ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
      objOut.writeObject(map);
    }
  }

  /**
   * Write V2 RainbowFish to file.
   */
  public static void writeV2(RainbowFishV2 rainbowFish, String filename) throws IOException {
    final Map<String, String> map = Map.of(
        "name", rainbowFish.getName(),
        "age", String.format("%d", rainbowFish.getAge()),
        LENGTH_METERS, String.format("%d", rainbowFish.getLength()),
        WEIGHT_TONS, String.format("%d", rainbowFish.getWeight()),
        "angry", Boolean.toString(rainbowFish.isAngry()),
        "hungry", Boolean.toString(rainbowFish.isHungry()),
        "sleeping", Boolean.toString(rainbowFish.isSleeping())
    );

    try (final FileOutputStream fileOut = new FileOutputStream(filename);
        final ObjectOutputStream objOut = new ObjectOutputStream(fileOut)) {
      objOut.writeObject(map);
    }
  }

  public static RainbowFish readV1(String filename) throws IOException, ClassNotFoundException {
    Map<String, String> map;

    try (final FileInputStream fileIn = new FileInputStream(filename);
        final ObjectInputStream objIn = new ObjectInputStream(fileIn)) {
      map = (Map<String, String>) objIn.readObject();
    }

    return new RainbowFish(
        map.get("name"),
        Integer.parseInt(map.get("age")),
        Integer.parseInt(map.get(LENGTH_METERS)),
        Integer.parseInt(map.get(WEIGHT_TONS))
    );
  }
}
