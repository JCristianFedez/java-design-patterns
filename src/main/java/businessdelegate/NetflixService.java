package businessdelegate;

import commons.logger.Logger;

public class NetflixService implements VideoStreamingService {
  private static final Logger LOGGER = Logger.fromType(YouTubeService.class);

  @Override
  public void doProcessing() {
    LOGGER.info("NetflixService is now processing");
  }
}
