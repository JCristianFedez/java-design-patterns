package com.cristian.design.patterns.example1;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

import com.cristian.design.patterns.logger.constants.EnvParameters;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class FileDataSource implements DataSource {

  private final String name;

  public FileDataSource(final String name) {
    this.name = name;
  }

  @Override
  public void writeData(final String data) {
    final File file = new File(this.getPathname());
    try (final OutputStream fos = Files.newOutputStream(file.toPath())) {
      fos.write(data.getBytes());
    } catch (IOException e) {
      LOGGER.trace("Thrown", e);
    }
  }

  @Override
  public String readData() {
    char[] buffer = null;
    final File file = new File(this.getPathname());
    try (final FileReader reader = new FileReader(file)) {
      buffer = new char[(int) file.length()];
      reader.read(buffer);
    } catch (IOException e) {
      LOGGER.trace("Thrown", e);
    }
    assert buffer != null;
    return new String(buffer);
  }

  private String getPathname() {
    return EnvParameters.GENERATED_FILE_URL.buildValue("decorators") + this.name;
  }
}
