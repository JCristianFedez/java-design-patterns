package com.cristian.design.patterns.somelibrary;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Random;

import com.cristian.design.patterns.logger.Logger;

public class ThirdPartyYouTubeClass implements ThirdPartyYouTubeLib {

  private static final Random random = new SecureRandom();

  private static final Logger LOGGER = Logger.fromType(ThirdPartyYouTubeClass.class);

  @Override
  public HashMap<String, Video> popularVideos() {
    this.connectToServer("http://www.youtube.com");
    return getRandomVideos();
  }

  @Override
  public Video getVideo(final String videoId) {
    this.connectToServer("http://www.youtube.com");
    return this.getSomeVideo(videoId);
  }

  // -----------------------------------------------------------------------
  // Métodos falsos para simular la actividad de la red. Son tan lentos como la vida real.

  private void experienceNetworkLatency() {
    final int randomLatency = random.nextInt(5) + 5;
    for (int i = 0; i < randomLatency; i++) {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  private void connectToServer(final String server) {
    LOGGER.debug("Connecting to %s ...", server);
    this.experienceNetworkLatency();
    LOGGER.debug("Connected");
  }

  private HashMap<String, Video> getRandomVideos() {
    LOGGER.debug("Downloading populars... ");

    this.experienceNetworkLatency();
    final HashMap<String, Video> map = new HashMap<>();
    map.put("catzzzzzzzzz", new Video("sadgahasgdas", "Catzzzz.avi"));
    map.put("mkafksangasj", new Video("mkafksangasj", "Dog play with ball.mp4"));
    map.put("dancesvideoo", new Video("asdfas3ffasd", "Dancing video.mpq"));
    map.put("dlsdk5jfslaf", new Video("dlsdk5jfslaf", "Barcelona vs RealM.mov"));
    map.put("3sdfgsd1j333", new Video("3sdfgsd1j333", "Programing lesson#1.avi"));

    LOGGER.debug("Done:");
    return map;
  }

  private Video getSomeVideo(final String videoId) {
    LOGGER.debug("Downloading video...");

    this.experienceNetworkLatency();
    final Video video = new Video(videoId, "Titulo de video");

    LOGGER.debug("Done");
    return video;
  }
}
