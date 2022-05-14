package builder.cars.builder;

import builder.cars.CarType;
import builder.components.engine.Engine;
import builder.components.transmission.Transmission;

public class Director {

  public void constructSportsCar(final Builder builder) {
    builder.setCarType(CarType.SPORTS_CAR)
        .setSeats(2)
        .setEngine(new Engine(3.0, 0))
        .setTransmission(Transmission.SEMI_AUTOMATIC);
  }

  public void constructCityCar(final Builder builder) {
    builder.setCarType(CarType.CITY_CAR)
        .setSeats(2)
        .setEngine(new Engine(1.2, 0))
        .setTransmission(Transmission.AUTOMATIC);
  }

  public void constructSUV(final Builder builder) {
    builder.setCarType(CarType.SUV)
        .setSeats(4)
        .setEngine(new Engine(2.5, 0))
        .setTransmission(Transmission.MANUAL);
  }
}
