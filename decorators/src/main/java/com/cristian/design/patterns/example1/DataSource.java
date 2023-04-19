package com.cristian.design.patterns.example1;

/**
 * Interfaz común de datos que define operaciones de leer y escribir.
 */
interface DataSource {

  void writeData(final String data);

  String readData();
}
