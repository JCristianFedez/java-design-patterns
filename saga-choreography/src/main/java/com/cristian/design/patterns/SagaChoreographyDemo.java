package com.cristian.design.patterns;

import com.cristian.design.patterns.service.FlyBookingService;
import com.cristian.design.patterns.service.HotelBookingService;
import com.cristian.design.patterns.service.OrderService;
import com.cristian.design.patterns.service.ServiceDiscoveryService;
import com.cristian.design.patterns.service.WithdrawMoneyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SagaChoreographyDemo {

  public static void main(String[] args) {
    final ServiceDiscoveryService sd = serviceDiscovery();
    final ChoreographyChapter service = sd.findAny();

    LOGGER.info("==== GOOD ORDER ====");
    final Saga goodOrderSaga = service.execute(newSaga("good_order"));

    LOGGER.info("==== BAD ORDER ====");
    final Saga badOrderSaga = service.execute(newSaga("bad_order"));

    LOGGER.info("orders: goodOrder is {}, badOrder is {}", goodOrderSaga.result(), badOrderSaga.result());
  }

  private static Saga newSaga(Object value) {
    return Saga
        .create()
        .addChapter("Init an order").setInValue(value)
        .addChapter("Booking a Fly")
        .addChapter("Booking a Hotel")
        .addChapter("Withdrawing Money");
  }

  private static ServiceDiscoveryService serviceDiscovery() {
    final ServiceDiscoveryService sd = new ServiceDiscoveryService();
    return sd.discover(new OrderService(sd))
        .discover(new FlyBookingService(sd))
        .discover(new HotelBookingService(sd))
        .discover(new WithdrawMoneyService(sd));
  }
}
