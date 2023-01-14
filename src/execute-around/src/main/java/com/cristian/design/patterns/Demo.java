package com.cristian.design.patterns;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Demo {

  public static final String FILENAME = "testFile.txt";

  public static void main(String[] args) throws IOException {
    new Demo().run();
  }

  private void run() throws IOException {
    createFile();
    printFileContent();
  }

  private static void createFile() throws IOException {
    final FileWriterAction writeHello = writer -> writer.write("Gandalf was here");
    new SimpleFileWriter(FILENAME, writeHello);
  }

  private static void printFileContent() throws FileNotFoundException {
    System.out.println("\nStart to read file");
    try (final Scanner scanner = new Scanner(new File(FILENAME))) {
      while (scanner.hasNextLine()) {
        System.out.println(scanner.nextLine());
      }
    }
  }
}
