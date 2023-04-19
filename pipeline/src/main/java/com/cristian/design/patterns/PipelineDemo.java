package com.cristian.design.patterns;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PipelineDemo {

  public static void main(String[] args) {
    final Pipeline<String, char[]> filters =
        new Pipeline<>(new RemoveAlphabetsHandler())
            .addHandler(new RemoveDigitsHandler())
            .addHandler(new ConvertToCharArrayHandler());

    LOGGER.info(Arrays.toString(filters.execute("GoYankees123!")));
  }
}
