package singleton.ejemplo2.withsecurityonthreads;

public class Singleton {

  private static Singleton instance;

  private int value;

  private Singleton(final int value) {
    this.value = value;
  }

  public static Singleton getInstance(final int value) {
    Singleton result = instance;
    if (result != null) {
      return result;
    }
    synchronized (Singleton.class) {
      if (instance == null) {
        instance = new Singleton(value);
      }
      return instance;
    }
  }

  public static Singleton getInstance() {
    return getInstance(0);
  }

  public int getValue() {
    return value;
  }

  public void setValue(final int value) {
    this.value = value;
  }
}
