package com.cristian.design.patterns;

import com.cristian.design.patterns.service.FlyBookingService;
import com.cristian.design.patterns.service.HotelBookingService;
import com.cristian.design.patterns.service.OrderService;
import com.cristian.design.patterns.service.ServiceDiscoveryService;
import com.cristian.design.patterns.service.WithdrawMoneyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SagaOrchestrationDemo {
  public static void main(String[] args) {
    final SagaOrchestrator sagaOrchestrator = new SagaOrchestrator(newSaga(), serviceDiscovery());

    LOGGER.info("==== GOOD ORDER ====");
    Saga.Result goodOrder = sagaOrchestrator.execute("good_order");

    LOGGER.info("==== BAD ORDER ====");
    Saga.Result badOrder = sagaOrchestrator.execute("bad_order");

    LOGGER.info("==== CRASHED ORDER ====");
    Saga.Result crashedOrder = sagaOrchestrator.execute("crashed_order");

    LOGGER.info("orders: goodOrder is {}, badOrder is {},crashedOrder is {}",
        goodOrder, badOrder, crashedOrder);
  }


  private static Saga newSaga() {
    return Saga
        .create()
        .chapter("Init an order")
        .chapter("Booking a Fly")
        .chapter("Booking a Hotel")
        .chapter("Withdrawing Money");
  }

  private static ServiceDiscoveryService serviceDiscovery() {
    return new ServiceDiscoveryService()
        .discover(new OrderService())
        .discover(new FlyBookingService())
        .discover(new HotelBookingService())
        .discover(new WithdrawMoneyService());
  }
}
