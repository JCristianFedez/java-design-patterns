package com.cristian.design.patterns.proxy;

import java.util.HashMap;

import com.cristian.design.patterns.somelibrary.ThirdPartyYouTubeClass;
import com.cristian.design.patterns.somelibrary.ThirdPartyYouTubeLib;
import com.cristian.design.patterns.somelibrary.Video;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

  private final ThirdPartyYouTubeLib youTubeService;

  private final HashMap<String, Video> cachePopular;

  private final HashMap<String, Video> cacheAll;

  public YouTubeCacheProxy() {
    this.youTubeService = new ThirdPartyYouTubeClass();
    this.cachePopular = new HashMap<>();
    this.cacheAll = new HashMap<>();
  }

  @Override
  public HashMap<String, Video> popularVideos() {
    if (this.cachePopular.isEmpty()) {
      this.cachePopular.putAll(this.youTubeService.popularVideos());
    } else {
      log.debug("Lista recuperada del caché");
    }
    return this.cachePopular;
  }

  @Override
  public Video getVideo(final String videoId) {
    Video video = this.cacheAll.get(videoId);
    if (video == null) {
      video = this.youTubeService.getVideo(videoId);
      cacheAll.put(videoId, video);
    } else {
      log.debug("Video {} recuperado de cache", video);
    }

    return video;
  }

  public void reset() {
    this.cacheAll.clear();
    this.cachePopular.clear();
  }
}
