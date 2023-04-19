package com.cristian.design.patterns.timer;

import java.util.Timer;
import java.util.TimerTask;

import com.cristian.design.patterns.models.CallsCount;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ThrottleTimerImpl implements Throttler {

  private final int throttlePeriod;

  private final CallsCount callsCount;

  @Override
  public void start() {
    new Timer(true).schedule(new TimerTask() {
      @Override
      public void run() {
        callsCount.reset();
      }
    }, 0, throttlePeriod);
  }
}
