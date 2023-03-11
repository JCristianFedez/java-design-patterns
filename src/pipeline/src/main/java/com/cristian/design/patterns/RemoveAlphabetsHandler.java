package com.cristian.design.patterns;

import java.util.function.IntPredicate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoveAlphabetsHandler implements Handler<String, String> {

  @Override
  public String process(final String input) {
    final StringBuilder inputWithoutAlphabets = new StringBuilder();
    final IntPredicate isAlphabetic = Character::isAlphabetic;
    input.chars()
        .filter(isAlphabetic.negate())
        .mapToObj(x -> (char) x)
        .forEachOrdered(inputWithoutAlphabets::append);

    final String inputWithoutAlphabetsStr = inputWithoutAlphabets.toString();
    LOGGER.info("Current handler: {}, input is {} of type {}, output is {}, of type {}",
        RemoveAlphabetsHandler.class, input, String.class, inputWithoutAlphabetsStr, String.class);

    return inputWithoutAlphabetsStr;
  }
}
