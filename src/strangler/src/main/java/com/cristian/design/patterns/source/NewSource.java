package com.cristian.design.patterns.source;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NewSource {

  private static final String VERSION = "2.0";

  public int accumulateSum(final int... nums) {
    version();
    return Arrays.stream(nums).reduce(0, Integer::sum);
  }

  public int accumulateMul(final int... nums) {
    version();
    return Arrays.stream(nums).reduce(1, (a, b) -> a * b);
  }

  public boolean ifNonZero(final int... nums) {
    version();
    return Arrays.stream(nums).allMatch(num -> num != 0);
  }

  private void version() {
    LOGGER.info("Source module {}", VERSION);
  }
}
