package com.cristian.design.patterns.service;

import java.util.function.Supplier;

import com.cristian.design.patterns.ChoreographyChapter;
import com.cristian.design.patterns.Saga;
import com.cristian.design.patterns.Saga.ChapterResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class Service implements ChoreographyChapter {

  private final ServiceDiscoveryService sd;

  @Override
  public Saga execute(final Saga saga) {
    Saga nextSaga = saga;
    Object nextVal;
    final String chapterName = saga.getCurrent().getName();
    if (chapterName.equals(getName())) {
      if (saga.isForward()) {
        nextSaga = process(saga);
        nextVal = nextSaga.getCurrentValue();
        if (nextSaga.isCurrentSuccess()) {
          nextSaga.forward();
        } else {
          nextSaga.back();
        }
      } else {
        nextSaga = rollback(saga);
        nextVal = nextSaga.getCurrentValue();
        nextSaga.back();
      }

      if (isSagaFinished(nextSaga)) {
        return nextSaga;
      }

      nextSaga.setCurrentValue(nextVal);
    }
    final Saga finalNextSaga = nextSaga;
    return sd.find(chapterName)
        .map(ch -> ch.execute(finalNextSaga))
        .orElseThrow(serviceNotFoundException(chapterName));
  }

  private Supplier<RuntimeException> serviceNotFoundException(final String chServiceName) {
    return () -> new RuntimeException(String.format("the service %s has not been found", chServiceName));
  }

  @Override
  public Saga process(final Saga saga) {
    final Object inValue = saga.getCurrentValue();
    LOGGER.info("The chapter {} has been started. The data {} has been stored or calculated successfully", getName(), inValue);
    saga.setCurrentStatus(ChapterResult.SUCCESS);
    saga.setCurrentValue(inValue);
    return saga;
  }

  @Override
  public Saga rollback(final Saga saga) {
    final Object inValue = saga.getCurrentValue();
    LOGGER.info("The Rollback for a chapter '{}' has been started. The data {} has been rollbacked successfully", getName(), inValue);
    saga.setCurrentStatus(ChapterResult.ROLLBACK);
    saga.setCurrentValue(inValue);
    return saga;

  }

  private boolean isSagaFinished(final Saga saga) {
    if (!saga.isPresent()) {
      saga.setFinished(true);
      LOGGER.info(" the saga has been finished with {} status", saga.result());
      return true;
    }
    return false;
  }
}
