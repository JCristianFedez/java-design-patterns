package com.cristian.design.patterns.example1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class Demo {

  public static void main(String[] args) {
    final String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
    final DataSourceDecorator encoded = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("OutputDemo.txt")));
    encoded.writeData(salaryRecords);
    final DataSource plain = new FileDataSource("OutputDemo.txt");

    log.debug("- Input ----------------");
    log.debug(salaryRecords);
    log.debug("- Encoded --------------");
    log.debug(plain.readData());
    log.debug("- Decoded --------------");
    log.debug(encoded.readData());
  }
}
