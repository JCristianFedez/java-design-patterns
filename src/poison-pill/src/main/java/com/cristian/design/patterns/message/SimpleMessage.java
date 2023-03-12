package com.cristian.design.patterns.message;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleMessage implements Message {

  private final Map<Headers, String> headers = new HashMap<>();

  private String body;

  @Override
  public void addHeader(final Headers header, final String value) {
    this.headers.put(header, value);
  }

  @Override
  public String getHeader(final Headers header) {
    return this.headers.get(header);
  }

  @Override
  public Map<Headers, String> getHeaders() {
    return Collections.unmodifiableMap(this.headers);
  }

  @Override
  public String getBody() {
    return this.body;
  }

  @Override
  public void setBody(final String body) {
    this.body = body;
  }
}
