package com.cristian.design.patterns.service;

import com.cristian.design.patterns.chapter.ChapterResult;
import com.cristian.design.patterns.chapter.OrchestrationChapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Service<K> implements OrchestrationChapter<K> {

  protected static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

  @Override
  public abstract String getName();

  @Override
  public ChapterResult<K> process(final K value) {
    LOGGER.info("The chapter {} has been started. The data {} has been started or calculated successfully", getName(), value);
    return ChapterResult.success(value);
  }

  @Override
  public ChapterResult<K> rollback(final K value) {
    LOGGER.info("The Rollback for a chapter {} has been started. The data {} has been rollbacked successfully", getName(), value);
    return ChapterResult.success(value);
  }
}
