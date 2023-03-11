package com.cristian.design.patterns;

import java.lang.reflect.Field;

public class FieldJsonMapper {

  public String toJson(final Video video, final String[] fields) throws Exception {
    final StringBuilder sb = new StringBuilder().append("{");
    int i = 0;
    while (i < fields.length) {
      sb.append(getString(video, Video.class.getDeclaredField(fields[i])));
      if (i != fields.length - 1) {
        sb.append(",");
      }
      i++;
    }
    sb.append("}");
    return sb.toString();
  }

  private String getString(final Video video, final Field declaredField) throws IllegalAccessException {
    declaredField.setAccessible(true);
    final Object value = declaredField.get(video);
    return String.format("\"%s\": \"%s\"", declaredField.getName(), value.toString());
  }
}
