package com.cristian.design.patterns;

import com.cristian.design.patterns.cars.Car;
import com.cristian.design.patterns.cars.CarType;
import com.cristian.design.patterns.cars.builder.CarBuilder;
import com.cristian.design.patterns.cars.builder.Director;
import com.cristian.design.patterns.components.engine.Engine;
import com.cristian.design.patterns.components.transmission.Transmission;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Demo {

  public static void main(String[] args) {
    final Director director = new Director();
    final CarBuilder builder = new CarBuilder();
    director.constructSportsCar(builder);
    final Car car = builder.build();

    log.info("Car built {}", car.toString());

    final CarBuilder manualBuilder = new CarBuilder();
    director.constructSportsCar(manualBuilder);
    manualBuilder.setSeats(200);
    final Car carManual = builder.build();

    log.info("CarManual built: {}", carManual.toString());

    final Car carBasic = Car.builder()
        .setCarType(CarType.CITY_CAR)
        .setTransmission(Transmission.AUTOMATIC)
        .setSeats(3)
        .setEngine(new Engine(1, 2))
        .build();

    log.info("CarBasic {}", carBasic);
  }
}
