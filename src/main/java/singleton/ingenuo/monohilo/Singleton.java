package singleton.ingenuo.monohilo;

class Singleton {

  private static Singleton instance;

  private final String value;

  private Singleton(final String value) {
    this.value = value;
  }

  public static Singleton getInstance(final String value) {
    if (instance == null) {
      instance = new Singleton(value);
    }
    return instance;
  }

  @Override
  public String toString() {
    return "Singleton{value=" + value + "}";
  }
}
