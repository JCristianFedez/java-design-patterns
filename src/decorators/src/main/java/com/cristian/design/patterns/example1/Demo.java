package com.cristian.design.patterns.example1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Demo {

  public static void main(String[] args) {
    final String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
    final DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("OutputDemo.txt")));
    encoded.writeData(salaryRecords);
    final DataSource plain = new FileDataSource("OutputDemo.txt");

    LOGGER.debug("- Input ----------------");
    LOGGER.debug(salaryRecords);
    LOGGER.debug("- Encoded --------------");
    LOGGER.debug(plain.readData());
    LOGGER.debug("- Decoded --------------");
    LOGGER.debug(encoded.readData());
  }
}
