package businessdelegate;

final class BusinessDelegate {

  private final BusinessLookup lookupService;

  public BusinessDelegate(final BusinessLookup lookupService) {
    this.lookupService = lookupService;
  }

  public void playbackMovie(final String movie) {
    final VideoStreamingService videoStreamingService = lookupService.getBusinessService(movie);
    videoStreamingService.doProcessing();
  }
}
