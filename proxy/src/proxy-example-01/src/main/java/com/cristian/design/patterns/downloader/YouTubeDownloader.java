package com.cristian.design.patterns.downloader;

import java.util.HashMap;

import com.cristian.design.patterns.somelibrary.ThirdPartyYouTubeLib;
import com.cristian.design.patterns.somelibrary.Video;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YouTubeDownloader {

  private final ThirdPartyYouTubeLib api;

  public YouTubeDownloader(final ThirdPartyYouTubeLib api) {
    this.api = api;
  }

  public void renderVideoPage(final String videoId) {
    final Video video = this.api.getVideo(videoId);
    LOGGER.debug("\n-------------------------------");
    LOGGER.debug("Pagina de videos (imagínese HTML elegante)");
    LOGGER.debug(video.toString());
    LOGGER.debug("-------------------------------\n");
  }

  public void renderPopularVideo() {
    final HashMap<String, Video> map = this.api.popularVideos();
    LOGGER.debug("Los videos más populares en YouTube (imagínese HTML elegante)");
    map.forEach((s, video) -> LOGGER.debug(video.toString()));
    LOGGER.debug("\n-------------------------------");
    LOGGER.debug("-------------------------------\n");
  }
}
