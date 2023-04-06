package com.cristian.design.patterns.arithmetic;

import com.cristian.design.patterns.source.NewSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class NewArithmetic {

  private static final String VERSION = "2.0";

  private final NewSource source;

  public int sum(final int... nums) {
    LOGGER.info("Arithmetic sum {}", VERSION);
    return this.source.accumulateSum(nums);
  }

  public int mul(final int... nums) {
    LOGGER.info("Arithmetic mul {}", VERSION);
    return this.source.accumulateMul(nums);
  }

  public boolean ifHasZero(final int... nums) {
    LOGGER.info("Arithmetic check zero {}", VERSION);
    return !this.source.ifNonZero(nums);
  }
}
