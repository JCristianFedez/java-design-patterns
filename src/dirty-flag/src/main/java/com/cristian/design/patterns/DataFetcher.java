package com.cristian.design.patterns;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class DataFetcher {

  private static final String FILE_NAME = "world.txt";

  private long lastFetched = -1;

  private boolean isDirty(final long fileLastModified) {
    if (this.lastFetched != fileLastModified) {
      this.lastFetched = fileLastModified;
      return true;
    }
    return false;
  }

  public List<String> fetch() {
    final File file = new File(Objects.requireNonNull(getClass().getResource(FILE_NAME)).getFile());

    if (isDirty(file.lastModified())) {
      System.out.printf("{} is dirty! Re-fetching file content...%n", FILE_NAME);
      try (final BufferedReader br = new BufferedReader(new FileReader(file))) {
        return br.lines().collect(Collectors.toList());
      } catch (final IOException e) {
        e.printStackTrace();
      }
    }

    return Collections.emptyList();
  }
}
