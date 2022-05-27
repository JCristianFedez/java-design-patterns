package singleton.ingenuo.multihilo;

import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class Singleton {

  private static Singleton INSTANCE;

  public String value;

  private Singleton(final String value) {
    // Simulamos un inicio lento
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    this.value = value;
  }

  public static Singleton getInstance(final String value) {
    if (INSTANCE == null) {
      INSTANCE = new Singleton(value);
    }
    return INSTANCE;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Singleton.class.getSimpleName() + "[", "]")
        .add("value='" + value + "'")
        .toString();
  }
}
