package com.cristian.design.patterns;

public class RoyaltyObjectMother {

  private RoyaltyObjectMother() {
  }

  /**
   * Method to create a sober and unhappy king. The standard parameters are set.
   *
   * @return An instance of {@link King} with the standard properties.
   */
  public static King createSoberUnhappyKing() {
    return new King();
  }

  /**
   * Method of the object mother to create a drunk king.
   *
   * @return A drunk {@link King}.
   */
  public static King createDrunkKing() {
    var king = new King();
    king.makeDrunk();
    return king;
  }

  /**
   * Method to create a happy king.
   *
   * @return A happy {@link King}.
   */
  public static King createHappyKing() {
    var king = new King();
    king.makeHappy();
    return king;
  }

  /**
   * Method to create a happy and drunk king.
   *
   * @return A drunk and happy {@link King}.
   */
  public static King createHappyDrunkKing() {
    var king = new King();
    king.makeHappy();
    king.makeDrunk();
    return king;
  }

  /**
   * Method to create a flirty queen.
   *
   * @return A flirty {@link Queen}.
   */
  public static Queen createFlirtyQueen() {
    var queen = new Queen();
    queen.setFlirtiness(true);
    return queen;
  }

  /**
   * Method to create a not flirty queen.
   *
   * @return A not flirty {@link Queen}.
   */
  public static Queen createNotFlirtyQueen() {
    return new Queen();
  }
}
