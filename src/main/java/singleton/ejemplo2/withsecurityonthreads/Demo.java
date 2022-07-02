package singleton.ejemplo2.withsecurityonthreads;

public class Demo {

  public static void main(String[] args) {
    new Thread(() -> {
      final Singleton singleton = Singleton.getInstance(2);
      printSingletons(singleton);
    }).start();
    simulatePing();

    new Thread(() -> {
      final Singleton singleton = Singleton.getInstance();
      printSingletons(singleton);
      singleton.setValue(20);
      printSingletons(singleton);
    }).start();
    simulatePing();

    new Thread(() -> {
      final Singleton singleton = Singleton.getInstance();
      printSingletons(singleton);
    }).start();
  }

  private static void simulatePing() {
    try {
      Thread.sleep(100L);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private static void printSingletons(final Singleton singleton) {
    System.out.println("singleton = " + singleton.getValue());
    System.out.println("=========================================");
  }

}
