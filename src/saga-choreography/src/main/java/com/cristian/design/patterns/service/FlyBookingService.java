package com.cristian.design.patterns.service;

public class FlyBookingService extends Service {

  public FlyBookingService(final ServiceDiscoveryService service) {
    super(service);
  }

  @Override
  public String getName() {
    return "Booking a Fly";
  }
}
