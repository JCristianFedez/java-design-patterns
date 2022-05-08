package builder;

import builder.cars.Car;
import builder.cars.builder.CarBuilder;
import builder.cars.builder.Director;
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

  }
}
