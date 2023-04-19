package com.cristian.design.pattern;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Student implements Serializable {

  private static final long serialVersionUID = 8877633097244313083L;

  @EqualsAndHashCode.Include
  private int studentId;

  private String name;

  private char grade;
}
