package com.cristian.design.patterns.arithmetic;

import com.cristian.design.patterns.source.HalfSource;
import com.cristian.design.patterns.source.OldSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class HalfArithmetic {

  private static final String VERSION = "1.5";

  private final HalfSource newSource;

  private final OldSource oldSource;

  public int sum(final int... nums) {
    LOGGER.info("Arithmetic sum {}", VERSION);
    return this.newSource.accumulateSum(nums);
  }

  public int mul(final int... nums) {
    LOGGER.info("Arithmetic mul {}", VERSION);
    return this.oldSource.accumulateMul(nums);
  }

  public boolean ifHasZero(final int... nums) {
    LOGGER.info("Arithmetic check zero {}", VERSION);
    return !this.newSource.ifNonZero(nums);
  }
}
