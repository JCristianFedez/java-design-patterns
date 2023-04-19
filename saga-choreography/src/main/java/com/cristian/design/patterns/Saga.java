package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Saga representation. Saga consists of chapters. Every ChoreographyChapter is executed a certain service.
 */
public class Saga {

  private final List<Chapter> chapters = new ArrayList<>();

  private int pos = 0;

  @Getter
  private boolean forward = true;

  @Setter
  private boolean finished = false;

  public static Saga create() {
    return new Saga();
  }

  public SagaResult result() {
    if (this.finished) {
      return this.forward ? SagaResult.FINISHED : SagaResult.ROLLBACKED;
    }
    return SagaResult.PROGRESS;
  }

  public Saga addChapter(final String name) {
    this.chapters.add(new Chapter(name));
    return this;
  }

  /**
   * Set value to last chapter.
   */
  public Saga setInValue(final Object value) {
    if (this.chapters.isEmpty()) {
      return this;
    }
    this.chapters.get(this.chapters.size() - 1).setInValue(value);
    return this;
  }

  /**
   * Get value from current chapter.
   */
  public Object getCurrentValue() {
    return this.chapters.get(this.pos).getInValue();
  }

  /**
   * Set value to current chapter.
   */
  public void setCurrentValue(final Object value) {
    this.chapters.get(this.pos).setInValue(value);
  }

  /**
   * Set status for current chapter.
   */
  public void setCurrentStatus(final ChapterResult result) {
    this.chapters.get(this.pos).setResult(result);
  }

  public int forward() {
    return ++this.pos;
  }

  public int back() {
    this.forward = false;
    return --this.pos;
  }

  public Chapter getCurrent() {
    return this.chapters.get(this.pos);
  }


  public boolean isPresent() {
    return this.pos >= 0 && this.pos < this.chapters.size();
  }

  public boolean isCurrentSuccess() {
    return this.chapters.get(this.pos).isSuccess();
  }

  public enum ChapterResult {
    INIT,
    SUCCESS,
    ROLLBACK
  }

  public enum SagaResult {
    PROGRESS,
    FINISHED,
    ROLLBACKED
  }

  public static class Chapter {

    @Getter
    private final String name;

    @Setter
    private ChapterResult result = ChapterResult.INIT;

    @Getter
    @Setter
    private Object inValue;

    public Chapter(final String name) {
      this.name = name;
    }

    public boolean isSuccess() {
      return ChapterResult.SUCCESS.equals(this.result);
    }
  }
}
