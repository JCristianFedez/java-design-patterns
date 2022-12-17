package com.cristian.design.patterns;

import java.util.Locale;

final class BusinessLookup {

  private final NetflixService netflixService;

  private final YouTubeService youTubeService;

  public BusinessLookup(final NetflixService netflixService, final YouTubeService youTubeService) {
    this.netflixService = netflixService;
    this.youTubeService = youTubeService;
  }

  public VideoStreamingService getBusinessService(final String movie) {
    if (movie.toLowerCase(Locale.ROOT).contains("die hard")) {
      return this.netflixService;
    } else {
      return this.youTubeService;
    }
  }
}
