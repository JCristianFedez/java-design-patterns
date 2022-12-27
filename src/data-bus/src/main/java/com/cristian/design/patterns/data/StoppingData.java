package com.cristian.design.patterns.data;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class StoppingData extends AbstractDataType {

  private final LocalDateTime when;

  public static DataType of(final LocalDateTime when) {
    return new StartingData(when);
  }
}
