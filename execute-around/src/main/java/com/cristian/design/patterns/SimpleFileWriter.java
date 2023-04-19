package com.cristian.design.patterns;

import java.io.FileWriter;
import java.io.IOException;

public class SimpleFileWriter {

  public SimpleFileWriter(final String filename, final FileWriterAction action) throws IOException {
    System.out.println("Before - Opening the file");
    try (final FileWriter writer = new FileWriter(filename)) {
      System.out.println("Executing the action");
      action.writeFile(writer);
      System.out.println("After - Closing the file");
    }
  }
}
