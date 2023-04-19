package com.cristian.design.patterns.service;

public class HotelBookingService extends Service{

  public HotelBookingService(final ServiceDiscoveryService service) {
    super(service);
  }

  @Override
  public String getName() {
    return "Booking a Hotel";
  }
}
