package builder.cars.builder;

import builder.cars.CarType;
import builder.components.engine.Engine;
import builder.components.transmission.Transmission;

public class Director {

  public void constructSportsCar(final Builder builder) {
    builder.setCarType(CarType.SPORTS_CAR);
    builder.setSeats(2);
    builder.setEngine(new Engine(3.0, 0));
    builder.setTransmission(Transmission.SEMI_AUTOMATIC);
  }

  public void constructCityCar(final Builder builder) {
    builder.setCarType(CarType.CITY_CAR);
    builder.setSeats(2);
    builder.setEngine(new Engine(1.2, 0));
    builder.setTransmission(Transmission.AUTOMATIC);
  }

  public void constructSUV(final Builder builder) {
    builder.setCarType(CarType.SUV);
    builder.setSeats(4);
    builder.setEngine(new Engine(2.5, 0));
    builder.setTransmission(Transmission.MANUAL);
  }
}
