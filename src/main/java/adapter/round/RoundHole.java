package adapter.round;

/**
 * RoundHole es compatible con ROundPegs.
 */
public class RoundHole {

  private final double radius;

  public RoundHole(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return this.radius;
  }

  public boolean fits(RoundPeg peg) {
    return (this.getRadius() >= peg.getRadius());
  }
}
