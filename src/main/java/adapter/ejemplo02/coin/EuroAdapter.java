package adapter.ejemplo02.coin;

public class EuroAdapter extends Dollar {

  private final Euro euro;

  public EuroAdapter(final Euro euro) {
    super(0);
    this.euro = euro;
  }

  @Override
  public double getQuantity() {
    final double v = this.euro.getQuantity() * 1.04;
    return this.euro.getQuantity() * 1.04;
  }
}
