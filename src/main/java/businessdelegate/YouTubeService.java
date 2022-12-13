package businessdelegate;

import commons.logger.Logger;

final class YouTubeService implements VideoStreamingService {

  private static final Logger LOGGER = Logger.fromType(YouTubeService.class);

  @Override
  public void doProcessing() {
    LOGGER.info("YouTubeService is now processing");
  }
}
