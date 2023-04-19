package com.cristian.design.patterns.somelibrary;

import java.util.HashMap;

public interface ThirdPartyYouTubeLib {

  HashMap<String, Video> popularVideos();

  Video getVideo(final String videoId);
}
