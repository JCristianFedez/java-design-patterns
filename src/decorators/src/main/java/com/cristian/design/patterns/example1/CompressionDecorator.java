package com.cristian.design.patterns.example1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class CompressionDecorator extends DataSourceDecorator {

  private int compLevel = 6;

  public CompressionDecorator(final DataSource wrapper) {
    super(wrapper);
  }

  public int getCompressionLevel() {
    return this.compLevel;
  }

  public void setCompLevel(final int compLevel) {
    this.compLevel = compLevel;
  }

  @Override
  public void writeData(final String data) {
    super.writeData(this.compress(data));
  }

  @Override
  public String readData() {
    return this.decompress(super.readData());
  }

  private String compress(final String data) {
    final byte[] result = data.getBytes();
    try {
      final ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
      final DeflaterOutputStream dos = new DeflaterOutputStream(bout, new Deflater(this.compLevel));
      dos.write(result);
      dos.close();
      bout.close();
      return Base64.getEncoder().encodeToString(bout.toByteArray());
    } catch (IOException ex) {
      log.trace("Thrown", ex);
      return null;
    }
  }

  private String decompress(final String data) {
    final byte[] result = Base64.getDecoder().decode(data);
    try {
      final InputStream in = new ByteArrayInputStream(result);
      final InflaterInputStream iin = new InflaterInputStream(in);
      final ByteArrayOutputStream bout = new ByteArrayOutputStream(512);
      int b;
      while ((b = iin.read()) != -1) {
        bout.write(b);
      }
      in.close();
      iin.close();
      bout.close();
      return bout.toString();
    } catch (IOException ex) {
      log.trace("Thrown", ex);
      return null;
    }
  }
}
