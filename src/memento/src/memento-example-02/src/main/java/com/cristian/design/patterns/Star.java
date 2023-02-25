package com.cristian.design.patterns;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString(callSuper = true)
public class Star {

  @Setter(AccessLevel.PRIVATE)
  private StarType type;

  private int ageYears;

  private int massTons;

  public void timePasses() {
    this.ageYears *= 2;
    this.massTons *= 8;
    switch (this.type) {
      case RED_GIANT -> setType(StarType.WHITE_DWARF);
      case SUN -> setType(StarType.RED_GIANT);
      case SUPERNOVA -> setType(StarType.DEAD);
      case WHITE_DWARF -> setType(StarType.SUPERNOVA);
      case DEAD -> this.massTons = 0;
      default -> throw new IllegalArgumentException("Star type invalid");
    }
  }

  public StarMemento getMemento() {
    return new StarMementoInternal(this);
  }

  public void setMemento(final StarMemento starMemento) {
    this.type = starMemento.getType();
    this.ageYears = starMemento.getAgeYears();
    this.massTons = starMemento.getMassTons();
  }

  @Getter
  private static final class StarMementoInternal implements StarMemento {

    private final StarType type;

    private final int ageYears;

    private final int massTons;

    private StarMementoInternal(final Star star) {
      this.type = star.type;
      this.ageYears = star.ageYears;
      this.massTons = star.massTons;
    }
  }
}
