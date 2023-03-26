package com.cristian.design.patterns.service;

import com.cristian.design.patterns.Saga;
import com.cristian.design.patterns.Saga.ChapterResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WithdrawMoneyService extends Service {

  public WithdrawMoneyService(final ServiceDiscoveryService sd) {
    super(sd);
  }

  @Override
  public String getName() {
    return "Withdrawing Money";
  }

  @Override
  public Saga process(final Saga saga) {
    final Object inValue = saga.getCurrentValue();

    if (inValue.equals("bad_order")) {
      LOGGER.info("The chapter '{}' has been started. But the exception has been raised. The rollback is about to start", getName());
      saga.setCurrentStatus(ChapterResult.ROLLBACK);
      return saga;
    }
    return super.process(saga);
  }
}
