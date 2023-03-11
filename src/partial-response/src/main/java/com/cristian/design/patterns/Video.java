package com.cristian.design.patterns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Video {

  private final int id;

  private final String title;

  private final int length;

  private final String description;

  private final String director;

  private final String language;

  @Override
  public String toString() {
    return String.format(
        "{\"id\": %d, \"title\": \"%s\", \"length\": %d, \"description\": \"%s\", \"director\": \"%s\", \"language\": \"%s\"}",
        this.id, this.title, this.length, this.description, this.director, this.language);
  }
}
