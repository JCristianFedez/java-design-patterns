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
    log.debug("\n-------------------------------");
    log.debug("Pagina de videos (imagínese HTML elegante)");
    log.debug(video.toString());
    log.debug("-------------------------------\n");
  }

  public void renderPopularVideo() {
    final HashMap<String, Video> map = this.api.popularVideos();
    log.debug("Los videos más populares en YouTube (imagínese HTML elegante)");
    map.forEach((s, video) -> log.debug(video.toString()));
    log.debug("\n-------------------------------");
    log.debug("-------------------------------\n");
  }
}
