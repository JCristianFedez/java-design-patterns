package com.cristian.design.patterns.chapter;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ChapterResult<K> {

  @Getter
  private final K value;

  private final State state;

  public static <K> ChapterResult<K> success(final K value) {
    return new ChapterResult<>(value, State.SUCCESS);
  }

  public static <K> ChapterResult<K> failure(final K value) {
    return new ChapterResult<>(value, State.FAILURE);
  }

  public boolean isSuccess() {
    return State.SUCCESS.equals(this.state);
  }

  public enum State {
    SUCCESS,
    FAILURE
  }
}
