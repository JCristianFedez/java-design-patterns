package com.cristian.design.patterns;

import java.util.Optional;

import com.cristian.design.patterns.Saga.Chapter;
import com.cristian.design.patterns.Saga.Result;
import com.cristian.design.patterns.chapter.ChapterResult;
import com.cristian.design.patterns.chapter.OrchestrationChapter;
import com.cristian.design.patterns.service.ServiceDiscoveryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class SagaOrchestrator {

  private final Saga saga;

  private final ServiceDiscoveryService sd;

  private final CurrentState state = new CurrentState();

  @SuppressWarnings("unchecked")
  public <K> Result execute(final K value) {
    this.state.cleanUp();
    LOGGER.info("The new saga is about to start");
    Result result = Result.FINISHED;
    K tempVal = value;
    while (true) {
      int next = this.state.current();
      final Chapter chapter = this.saga.get(next);
      final Optional<OrchestrationChapter<?>> srvOpt = this.sd.find(chapter.name());

      if (srvOpt.isEmpty()) {
        this.state.directionToBack();
        this.state.back();
        continue;
      }

      final OrchestrationChapter<K> srv = (OrchestrationChapter<K>) srvOpt.get();

      if (this.state.isForward()) {
        final ChapterResult<K> processRes = srv.process(tempVal);
        if (processRes.isSuccess()) {
          next = this.state.forward();
          tempVal = processRes.getValue();
        } else {
          this.state.directionToBack();
        }
      } else {
        final ChapterResult<K> rlRes = srv.rollback(tempVal);
        if (rlRes.isSuccess()) {
          next = this.state.back();
          tempVal = rlRes.getValue();
        } else {
          result = Result.CRASHED;
          next = this.state.back();
        }
      }
      if (!this.saga.isPresent(next)) {
        if (this.state.isForward()) {
          return Result.FINISHED;
        } else if (Result.CRASHED.equals(result)) {
          return Result.CRASHED;
        }
        return Result.ROLLBACK;
      }
    }
  }

  private static class CurrentState {

    private int currentNumber = 0;

    private boolean isForward = true;

    private void cleanUp() {
      this.currentNumber = 0;
      this.isForward = true;
    }

    private boolean isForward() {
      return this.isForward;
    }

    private void directionToBack() {
      this.isForward = false;
    }

    private int forward() {
      return ++this.currentNumber;
    }

    private int back() {
      return --this.currentNumber;
    }

    private int current() {
      return this.currentNumber;
    }
  }
}
