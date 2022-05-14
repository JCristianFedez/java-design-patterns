package builder.cars;

import builder.cars.builder.CarBuilder;
import builder.components.engine.Engine;
import builder.components.transmission.Transmission;

public class Car {

  private final CarType carType;

  private final int seats;

  private final Engine engine;

  private final Transmission transmission;

  public Car(CarBuilder carBuilder) {
    this.carType = carBuilder.getCarType();
    this.seats = carBuilder.getSeats();
    this.engine = carBuilder.getEngine();
    this.transmission = carBuilder.getTransmission();
  }

  public static CarBuilder builder() {
    return new CarBuilder();
  }

  public CarType getCarType() {
    return carType;
  }

  public int getSeats() {
    return seats;
  }

  public Engine getEngine() {
    return engine;
  }

  public Transmission getTransmission() {
    return transmission;
  }

  @Override
  public String toString() {
    return "Car{" + "carType=" + carType
        + ", seats=" + seats
        + ", engine=" + engine
        + ", transmission=" + transmission
        + '}';
  }
}
