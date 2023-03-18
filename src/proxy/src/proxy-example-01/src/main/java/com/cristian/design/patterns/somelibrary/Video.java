package com.cristian.design.patterns.somelibrary;

import java.util.StringJoiner;

public class Video {

  private final String id;

  private final String title;

  private final String data;

  public Video(final String id, final String title) {
    this.id = id;
    this.title = title;
    this.data = "Random video";
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getData() {
    return data;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Video.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("title='" + title + "'")
        .add("data='" + data + "'")
        .toString();
  }
}
