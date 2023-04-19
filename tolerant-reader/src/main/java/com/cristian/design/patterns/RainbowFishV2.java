package com.cristian.design.patterns;

import java.io.Serial;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class RainbowFishV2 extends RainbowFish {

  @Serial
  private static final long serialVersionUID = 3909620734838347038L;

  private boolean sleeping;

  private boolean hungry;

  private boolean angry;

  public RainbowFishV2(final String name, final int age, final int lengthMeters, final int weightTons) {
    super(name, age, lengthMeters, weightTons);
  }

  public RainbowFishV2(final String name, final int age, final int lengthMeters, final int weightTons, final boolean sleeping,
      final boolean hungry, final boolean angry) {
    this(name, age, lengthMeters, weightTons);
    this.sleeping = sleeping;
    this.hungry = hungry;
    this.angry = angry;
  }

}
