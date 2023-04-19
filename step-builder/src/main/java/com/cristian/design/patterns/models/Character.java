package com.cristian.design.patterns.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {

  private final String name;

  private String fighterClass;

  private String wizardClass;

  private String weapon;

  private String spell;

  private List<String> abilities;

  public Character(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append("[name=").append(name);
    if (fighterClass != null) {
      sb.append(", fighterClass=").append(fighterClass);
    }
    if (wizardClass != null) {
      sb.append(", wizardClass=").append(wizardClass);
    }
    if (weapon != null) {
      sb.append(", weapon=").append(weapon);
    }
    if (spell != null) {
      sb.append(", spell=").append(spell);
    }
    if (abilities != null && !abilities.isEmpty()) {
      sb.append(", abilities=").append(abilities);
    }
    sb.append("]");
    return sb.toString();
  }
}
