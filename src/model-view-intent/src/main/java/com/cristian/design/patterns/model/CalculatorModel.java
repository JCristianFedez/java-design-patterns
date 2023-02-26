package com.cristian.design.patterns.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CalculatorModel {

  /**
   * Current calculator output -> is affected by operations.
   **/
  private Double output;

  /**
   * Current calculator variable used for operations.
   **/
  private Double variable;
}
