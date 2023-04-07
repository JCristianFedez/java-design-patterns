package com.cristian.design.patterns;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TolerantReaderDemo01 {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    final RainbowFish fishV1 = new RainbowFish("Zed", 10, 11, 12);
    LOGGER.info("Fish v1 {}", fishV1);
    RainbowFishSerializer.writeV1(fishV1, "fish1.out");
    LOGGER.info("Deserialize Fish v1 {}", RainbowFishSerializer.readV1("fish1.out"));

    final RainbowFishV2 fishV2 = new RainbowFishV2("Scar", 5, 12, 15, true, true, true);
    LOGGER.info("Fish v2 {}", fishV2);
    RainbowFishSerializer.writeV2(fishV2, "fish2.out");
    LOGGER.info("Deserialize Fish v2 {}", RainbowFishSerializer.readV1("fish2.out"));

  }
}
