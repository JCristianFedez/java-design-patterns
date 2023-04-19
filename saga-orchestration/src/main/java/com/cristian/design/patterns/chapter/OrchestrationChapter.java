package com.cristian.design.patterns.chapter;

/**
 * ChoreographyChapter is an interface representing a contract for an external service.
 *
 * @param <K> is type for passing params
 */
public interface OrchestrationChapter<K> {

  String getName();

  ChapterResult<K> process(K value);

  ChapterResult<K> rollback(K value);
}
