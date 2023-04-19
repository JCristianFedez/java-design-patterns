package com.cristian.design.patterns.service;

import com.cristian.design.patterns.chapter.ChapterResult;

public class HotelBookingService extends Service<String> {

  @Override
  public String getName() {
    return "Booking a Hotel";
  }

  @Override
  public ChapterResult<String> rollback(final String value) {
    if ("crashed_order".equals(value)) {
      LOGGER.info("The Rollback for a chapter {} has been started. The data {} has been failed. The saga has been crashed.",
          getName(), value);
      return ChapterResult.failure(value);
    }

    LOGGER.info("The Rollback for a chapter {} has been started. The data {} has been rollbacked successfully", getName(), value);
    return super.rollback(value);
  }
}
