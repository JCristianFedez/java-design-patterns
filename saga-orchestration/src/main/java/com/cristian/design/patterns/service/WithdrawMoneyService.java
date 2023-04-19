package com.cristian.design.patterns.service;

import com.cristian.design.patterns.chapter.ChapterResult;

public class WithdrawMoneyService extends Service<String> {

  @Override
  public String getName() {
    return "Withdrawing Money";
  }

  @Override
  public ChapterResult<String> process(final String value) {
    if ("bad_order".equals(value) || "crashed_order".equals(value)) {
      LOGGER.info("The chapter {} has been started. But the exception has been raised. The rollback is about to start", getName());
      return ChapterResult.failure(value);
    }
    return super.process(value);
  }
}
