package proxy;

import commons.logger.Logger;
import proxy.downloader.YouTubeDownloader;
import proxy.proxy.YouTubeCacheProxy;
import proxy.somelibrary.ThirdPartyYouTubeClass;

public class Demo {

  private static final Logger LOGGER = Logger.fromType(Demo.class);

  public static void main(String[] args) {
    final YouTubeDownloader naiveDownloader = new YouTubeDownloader(new ThirdPartyYouTubeClass());
    final YouTubeDownloader smartDownloader = new YouTubeDownloader(new YouTubeCacheProxy());

    final long naive = test(naiveDownloader);
    final long smart = test(smartDownloader);

    LOGGER.debug("Tiempo ahorrado por el cacheo del proxy: %s ms", (naive - smart));
  }

  private static long test(final YouTubeDownloader downloader) {
    final long startTime = System.currentTimeMillis();

    // Comportamiento del usuario en nuestra aplicación:
    downloader.renderPopularVideo();
    downloader.renderVideoPage("catzzzzzzzzz");
    downloader.renderPopularVideo();
    downloader.renderVideoPage("dancesvideoo");

    // Los usuarios pueden visitar la misma página con bastante frecuencia.
    downloader.renderVideoPage("catzzzzzzzzz");
    downloader.renderVideoPage("someothervid");

    final long estimatedTime = System.currentTimeMillis() - startTime;
    LOGGER.debug("Tiempo transcurrido %s", estimatedTime);
    return estimatedTime;
  }
}
