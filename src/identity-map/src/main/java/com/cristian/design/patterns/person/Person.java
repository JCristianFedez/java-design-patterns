package com.cristian.design.patterns.person;

import java.io.Serial;
import java.io.Serializable;
import java.util.StringJoiner;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@AllArgsConstructor
public class Person implements Serializable {

  @Serial
  private static final long serialVersionUID = -4654300927629315415L;

  @EqualsAndHashCode.Include
  private int id;

  private String name;

  private long phone;

  @Override
  public String toString() {
    return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
        .add("id=" + id)
        .add("name='" + name + "'")
        .add("phone=" + phone)
        .toString();
  }
}
