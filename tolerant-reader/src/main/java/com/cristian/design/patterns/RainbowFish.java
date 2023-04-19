package com.cristian.design.patterns;

import java.io.Serial;
import java.io.Serializable;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class RainbowFish implements Serializable {

  @Serial
  private static final long serialVersionUID = -2925842024011365111L;

  private final String name;

  private final int age;

  private final int length;

  private final int weight;

}
