package activeobject;

public class Demo {

  public static void main(String[] args) throws InterruptedException {
    run();
  }

  private static void run() throws InterruptedException {
    for (int i = 0; i < 5; i++) {
      final String orgName = Orc.class.getSimpleName() + i;
      final ActiveCreature creature = new Orc(orgName);
      creature.eat();
      creature.roam();
    }
    Thread.sleep(1000L);
    System.exit(1);
  }
}
