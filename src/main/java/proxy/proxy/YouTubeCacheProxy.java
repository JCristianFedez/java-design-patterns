package proxy.proxy;

import java.util.HashMap;

import commons.logger.Logger;
import proxy.somelibrary.ThirdPartyYouTubeClass;
import proxy.somelibrary.ThirdPartyYouTubeLib;
import proxy.somelibrary.Video;

public class YouTubeCacheProxy implements ThirdPartyYouTubeLib {

  private static final Logger LOGGER = Logger.fromType(YouTubeCacheProxy.class);

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
      LOGGER.debug("Lista recuperada del caché");
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
      LOGGER.debug("Video %s recuperado de cache", video);
    }

    return video;
  }

  public void reset() {
    this.cacheAll.clear();
    this.cachePopular.clear();
  }
}
