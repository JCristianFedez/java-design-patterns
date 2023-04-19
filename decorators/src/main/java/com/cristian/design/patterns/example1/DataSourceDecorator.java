package com.cristian.design.patterns.example1;

class DataSourceDecorator implements DataSource {

  private final DataSource wrapper;

  DataSourceDecorator(final DataSource wrapper) {
    this.wrapper = wrapper;
  }

  @Override
  public void writeData(final String data) {
    wrapper.writeData(data);
  }

  @Override
  public String readData() {
    return this.wrapper.readData();
  }
}
