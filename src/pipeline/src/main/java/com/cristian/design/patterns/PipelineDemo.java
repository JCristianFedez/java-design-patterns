package com.cristian.design.patterns;

public class PipelineDemo {

  public static void main(String[] args) {
    final Pipeline<String, char[]> filters =
        new Pipeline<>(new RemoveAlphabetsHandler())
            .addHandler(new RemoveDigitsHandler())
            .addHandler(new ConvertToCharArrayHandler());
    filters.execute("GoYankees123!");
  }
}
