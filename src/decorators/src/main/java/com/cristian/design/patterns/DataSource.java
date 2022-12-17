package com.cristian.design.patterns;

/**
 * Interfaz común de datos que define operaciones de leer y escribir.
 */
public interface DataSource {

  void writeData(final String data);

  String readData();
}
