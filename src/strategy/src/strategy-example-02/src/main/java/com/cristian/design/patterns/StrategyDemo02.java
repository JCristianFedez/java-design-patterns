package com.cristian.design.patterns;

import com.cristian.design.patterns.models.DragonSlayer;
import com.cristian.design.patterns.strategies.LambdaStrategy;
import com.cristian.design.patterns.strategies.MeleeStrategy;
import com.cristian.design.patterns.strategies.ProjectileStrategy;
import com.cristian.design.patterns.strategies.SpellStrategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyDemo02 {

  private static final String RED_DRAGON_EMERGES = "Red dragon emerges.";

  private static final String GREEN_DRAGON_SPOTTED = "Green dragon spotted ahead!";

  private static final String BLACK_DRAGON_LANDS = "Black dragon lands before you.";

  public static void main(String[] args) {
    // GoF Strategy pattern
    LOGGER.info(GREEN_DRAGON_SPOTTED);
    DragonSlayer dragonSlayer = new DragonSlayer(new MeleeStrategy());
    dragonSlayer.goToBattle();
    LOGGER.info(RED_DRAGON_EMERGES);
    dragonSlayer.changeStrategy(new ProjectileStrategy());
    dragonSlayer.goToBattle();
    LOGGER.info(BLACK_DRAGON_LANDS);
    dragonSlayer.changeStrategy(new SpellStrategy());
    dragonSlayer.goToBattle();

    // Java 8 functional implementation Strategy pattern
    LOGGER.info(GREEN_DRAGON_SPOTTED);
    dragonSlayer = new DragonSlayer(() -> LOGGER.info("With your Excalibur you severe the dragon's head!"));
    dragonSlayer.goToBattle();
    LOGGER.info(RED_DRAGON_EMERGES);
    dragonSlayer.changeStrategy(() -> LOGGER.info("You shoot the dragon with the magical crossbow and it falls dead on the ground!"));
    dragonSlayer.goToBattle();
    LOGGER.info(BLACK_DRAGON_LANDS);
    dragonSlayer.changeStrategy(() -> LOGGER.info("You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"));
    dragonSlayer.goToBattle();

    // Java 8 lambda implementation with enum Strategy pattern
    LOGGER.info(GREEN_DRAGON_SPOTTED);
    dragonSlayer.changeStrategy(LambdaStrategy.Strategy.MeleeStrategy);
    dragonSlayer.goToBattle();
    LOGGER.info(RED_DRAGON_EMERGES);
    dragonSlayer.changeStrategy(LambdaStrategy.Strategy.ProjectileStrategy);
    dragonSlayer.goToBattle();
    LOGGER.info(BLACK_DRAGON_LANDS);
    dragonSlayer.changeStrategy(LambdaStrategy.Strategy.SpellStrategy);
    dragonSlayer.goToBattle();
  }
}
