package com.cristian.design.patterns.arithmetic;

import com.cristian.design.patterns.source.OldSource;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class OldArithmetic {

  private static final String VERSION = "1.0";

  private final OldSource source;

  public int sum(int... nums) {
    LOGGER.info("Arithmetic sum {}", VERSION);
    return this.source.accumulateSum(nums);
  }

  public int mul(int... nums) {
    LOGGER.info("Arithmetic mul {}", VERSION);
    return this.source.accumulateMul(nums);
  }
}
