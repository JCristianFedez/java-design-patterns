package com.cristian.design.patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoyaltyObjectMotherUnitTest {

  @Test
  void unsuccessfulKingFlirt() {
    final King soberUnhappyKing = RoyaltyObjectMother.createSoberUnhappyKing();
    final Queen flirtyQueen = RoyaltyObjectMother.createFlirtyQueen();

    soberUnhappyKing.flirt(flirtyQueen);

    Assertions.assertFalse(soberUnhappyKing.isHappy());
  }

  @Test
  void queenIsBlockingFlirtCauseDrunkKing() {
    final King drunkUnhappyKing = RoyaltyObjectMother.createDrunkKing();
    final Queen notFlirtyQueen = RoyaltyObjectMother.createNotFlirtyQueen();

    drunkUnhappyKing.flirt(notFlirtyQueen);

    Assertions.assertFalse(drunkUnhappyKing.isHappy());
  }

  @Test
  void queenIsBlockingFlirt() {
    final King soberHappyKing = RoyaltyObjectMother.createHappyKing();
    final Queen notFlirtyQueen = RoyaltyObjectMother.createNotFlirtyQueen();

    soberHappyKing.flirt(notFlirtyQueen);

    Assertions.assertFalse(soberHappyKing.isHappy());
  }

  @Test
  void successfullKingFlirt() {
    final King soberHappyKing = RoyaltyObjectMother.createHappyKing();
    final Queen flirtyQueen = RoyaltyObjectMother.createFlirtyQueen();

    soberHappyKing.flirt(flirtyQueen);

    Assertions.assertTrue(soberHappyKing.isHappy());
  }

  @Test
  void testQueenType() {
    final Queen flirtyQueen = RoyaltyObjectMother.createFlirtyQueen();
    final Queen notFlirtyQueen = RoyaltyObjectMother.createNotFlirtyQueen();

    Assertions.assertEquals(flirtyQueen.getClass(), Queen.class);
    Assertions.assertEquals(notFlirtyQueen.getClass(), Queen.class);
  }

  @Test
  void testKingType() {
    final King drunkKing = RoyaltyObjectMother.createDrunkKing();
    final King happyDrunkKing = RoyaltyObjectMother.createHappyDrunkKing();
    final King happyKing = RoyaltyObjectMother.createHappyKing();
    final King soberUnhappyKing = RoyaltyObjectMother.createSoberUnhappyKing();

    Assertions.assertEquals(drunkKing.getClass(), King.class);
    Assertions.assertEquals(happyDrunkKing.getClass(), King.class);
    Assertions.assertEquals(happyKing.getClass(), King.class);
    Assertions.assertEquals(soberUnhappyKing.getClass(), King.class);
  }
}