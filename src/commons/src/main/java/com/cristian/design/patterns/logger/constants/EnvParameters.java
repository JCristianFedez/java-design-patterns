package com.cristian.design.patterns.logger.constants;

public enum EnvParameters {
  LOG4J_URL("src/commons/src/main/resources/com/cristian/design/patterns/config/log4j.xml"),
  GENERATED_FILE_URL("src/{0}/src/main/resources/com/cristian/design/patterns/generatedFiles/");

  private final String value;

  EnvParameters(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public String buildValue(final String... params) {
    String value = getValue();
    for (int i = 0; i < params.length; i++) {
      final String toRemplace = String.format("{%s}", i);
      value = value.replace(toRemplace, params[i]);
    }
    return value;
  }
}
