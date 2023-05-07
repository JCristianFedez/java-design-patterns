package com.cristian.design.patterns.infrastructure.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {

  private JsonMapper() {
  }

  public static <T> String serialize(final T response) {
    try {
      return new ObjectMapper().writeValueAsString(response);
    } catch (JsonProcessingException e) {
      throw new RuntimeException("Error serializing object " + response.toString());
    }
  }
}
