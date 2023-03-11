package com.cristian.design.patterns;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertToCharArrayHandler implements Handler<String, char[]> {

  @Override
  public char[] process(final String input) {
    final char[] characters = input.toCharArray();
    final String string = Arrays.toString(characters);
    LOGGER.info("Current handler: {}, input is {} of type {}, output is {}, of type {}",
        ConvertToCharArrayHandler.class, input, String.class, string, Character[].class);
    return characters;
  }

}
