package com.cristian.design.patterns;

public class Demo {
  public static void main(String[] args) {

    // prepare the objects
    final BusinessLookup businessLookup = new BusinessLookup(new NetflixService(), new YouTubeService());
    final BusinessDelegate businessDelegate = new BusinessDelegate(businessLookup);

    // create the client and use the business delegate
    final MobileClient client = new MobileClient(businessDelegate);
    client.playbackMovie("Die Hard 2");
    client.playbackMovie("Maradona: The Greatest Ever");
  }
}
