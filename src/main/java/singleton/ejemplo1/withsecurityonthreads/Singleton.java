package singleton.ejemplo1.withsecurityonthreads;

import java.util.StringJoiner;

public final class Singleton {

  //  El campo debe declararse volátil para que el bloqueo de doble verificación funcione correctamente.
  private static volatile Singleton INSTANCE;

  public String value;

  private Singleton(final String value) {
    this.value = value;
  }

  //  El enfoque adoptado aquí se denomina bloqueo de doble comprobación (DCL). Eso
  //  existe para evitar la condición de carrera entre varios subprocesos que pueden
  //  intente obtener una instancia de singleton al mismo tiempo, creando
  //  instancias como resultado.
  //  Puede parecer que tener la variable `resultado` aquí es completamente
  //  inútil. Sin embargo, hay una advertencia muy importante cuando
  //  implementando el bloqueo de doble verificación en Java, que se resuelve mediante
  //  introduciendo esta variable local.
  //  Puede leer más información sobre problemas de DCL en Java aquí:
  //  https://refactoring.guru/java-dcl-issue
  public static Singleton getInstance(final String value) {
    final Singleton result = INSTANCE;
    if (result != null) {
      return result;
    }
    synchronized (Singleton.class) {
      if (INSTANCE == null) {
        INSTANCE = new Singleton(value);
      }
      return INSTANCE;
    }
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Singleton.class.getSimpleName() + "[", "]")
        .add("value='" + value + "'")
        .toString();
  }
}
