package com.cristian.design.patterns.source;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OldSource {

  private static final String VERSION = "1.0";

  public int accumulateSum(final int... nums) {
    version();
    int sum = 0;
    for (final int num : nums) {
      sum += num;
    }
    return sum;
  }

  public int accumulateMul(final int... nums) {
    version();
    int mul = 0;
    for (final int num : nums) {
      mul *= num;
    }
    return mul;
  }

  private void version() {
    LOGGER.info("Source module {}", VERSION);
  }
}
