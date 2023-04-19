package com.cristian.design.patterns;

import java.util.function.IntPredicate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoveDigitsHandler implements Handler<String, String> {

  @Override
  public String process(final String input) {
    final StringBuilder inputWithoutDigits = new StringBuilder();
    final IntPredicate isDigit = Character::isDigit;
    input.chars()
        .filter(isDigit.negate())
        .mapToObj(x -> (char) x)
        .forEachOrdered(inputWithoutDigits::append);

    final String inputWithoutDigitsStr = inputWithoutDigits.toString();
    LOGGER.info("Current handler: {}, input is {} of type {}, output is {}, of type {}",
        RemoveDigitsHandler.class.getSimpleName(), input, String.class.getSimpleName(), inputWithoutDigitsStr,
        String.class.getSimpleName());

    return inputWithoutDigitsStr;

  }
}
