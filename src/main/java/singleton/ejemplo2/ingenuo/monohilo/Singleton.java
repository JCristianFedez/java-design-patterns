package singleton.ejemplo2.ingenuo.monohilo;

public class Singleton {

  private static Singleton instance = null;

  private int value;

  private Singleton(final int value) {
    this.value = value;
  }

  public static Singleton getInstance(int value) {
    if (instance == null) {
      instance = new Singleton(value);
    }
    return instance;
  }

  public static Singleton getInstance() {
    return getInstance(0);
  }

  public int getValue() {
    return this.value;
  }

  public void setValue(final int value) {
    this.value = value;
  }
}
