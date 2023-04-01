package com.cristian.design.patterns;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Data {

  private int key;

  private String value;

  private DataType type;

  public enum DataType {
    TYPE_1,
    TYPE_2,
    TYPE_3
  }
}
