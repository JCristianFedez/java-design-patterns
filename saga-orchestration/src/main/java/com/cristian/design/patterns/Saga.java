package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.List;

public class Saga {

  private final List<Chapter> chapters = new ArrayList<>();

  private Saga() {
  }

  public static Saga create() {
    return new Saga();
  }

  public Saga chapter(final String name) {
    this.chapters.add(new Chapter(name));
    return this;
  }

  public Chapter get(final int index) {
    return this.chapters.get(index);
  }

  public boolean isPresent(final int index) {
    return index >= 0 && index < this.chapters.size();
  }

  public enum Result {
    FINISHED,
    ROLLBACK,
    CRASHED
  }

  public record Chapter(String name) {

  }
}
