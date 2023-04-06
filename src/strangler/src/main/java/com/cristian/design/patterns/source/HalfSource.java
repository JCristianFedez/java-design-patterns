package com.cristian.design.patterns.source;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HalfSource {

  private static final String VERSION = "1.5";

  public int accumulateSum(final int... nums) {
    version();
    return Arrays.stream(nums).reduce(0, Integer::sum);
  }

  public boolean ifNonZero(final int... nums) {
    version();
    return Arrays.stream(nums).allMatch(num -> num != 0);
  }

  private void version() {
    LOGGER.info("Source module {}", VERSION);
  }

}
