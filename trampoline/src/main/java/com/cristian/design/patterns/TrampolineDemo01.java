package com.cristian.design.patterns;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrampolineDemo01 {

  public static void main(String[] args) {
    LOGGER.info("Start calculating war casualties");
    final Integer result = loop(300, 50).result();
    LOGGER.info("The number of orcs perished in the war: {}", result);
  }

  private static Trampoline<Integer> loop(final int times, final int prod) {
    if (times == 0) {
      return Trampoline.done(prod);
    } else {
      return Trampoline.more(() -> loop(times - 1, prod * times));
    }
  }

}
