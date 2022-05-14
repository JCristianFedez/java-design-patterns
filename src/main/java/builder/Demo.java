package builder;

import builder.cars.Car;
import builder.cars.CarType;
import builder.cars.builder.CarBuilder;
import builder.cars.builder.Director;
import builder.components.engine.Engine;
import builder.components.transmission.Transmission;
import commons.logger.Logger;

public class Demo {

  private static final Logger LOGGER = Logger.fromType(Demo.class);

  public static void main(String[] args) {
    final Director director = new Director();
    final CarBuilder builder = new CarBuilder();
    director.constructSportsCar(builder);
    final Car car = builder.build();

    LOGGER.info("Car built %s", car.toString());

    final CarBuilder manualBuilder = new CarBuilder();
    director.constructSportsCar(manualBuilder);
    manualBuilder.setSeats(200);
    final Car carManual = builder.build();

    LOGGER.info("CarManual built: %s", carManual.toString());

    final Car carBasic = Car.builder()
        .setCarType(CarType.CITY_CAR)
        .setTransmission(Transmission.AUTOMATIC)
        .setSeats(3)
        .setEngine(new Engine(1, 2))
        .build();

    LOGGER.info("CarBasic %s", carBasic);
  }
}
