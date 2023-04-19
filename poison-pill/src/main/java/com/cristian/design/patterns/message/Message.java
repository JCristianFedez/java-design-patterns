package com.cristian.design.patterns.message;

import java.util.Map;

public interface Message {

  Message POISON_PILL = new Message() {
    @Override
    public void addHeader(Headers header, String value) {
      throw poison();
    }

    @Override
    public String getHeader(Headers header) {
      throw poison();
    }

    @Override
    public Map<Headers, String> getHeaders() {
      throw poison();
    }

    @Override
    public String getBody() {
      throw poison();
    }

    @Override
    public void setBody(String body) {
      throw poison();
    }

    private RuntimeException poison() {
      return new UnsupportedOperationException("Poison");
    }
  };

  void addHeader(Headers header, String value);

  String getHeader(Headers header);

  Map<Headers, String> getHeaders();

  String getBody();

  void setBody(String body);

  enum Headers {
    DATE,
    SENDER
  }
}
