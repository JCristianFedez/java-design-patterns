package builder.cars.builder;

import builder.cars.Car;
import builder.cars.CarType;
import builder.components.engine.Engine;
import builder.components.transmission.Transmission;

public class CarBuilder implements Builder {

  private CarType carType;

  private int seats;

  private Engine engine;

  private Transmission transmission;

  public Car build() {
    return new Car(this);
  }

  public CarType getCarType() {
    return carType;
  }

  @Override
  public CarBuilder setCarType(final CarType carType) {
    this.carType = carType;
    return this;
  }

  public int getSeats() {
    return seats;
  }

  @Override
  public CarBuilder setSeats(final int seats) {
    this.seats = seats;
    return this;
  }

  public Engine getEngine() {
    return engine;
  }

  @Override
  public CarBuilder setEngine(final Engine engine) {
    this.engine = engine;
    return this;
  }

  public Transmission getTransmission() {
    return transmission;
  }

  @Override
  public CarBuilder setTransmission(final Transmission transmission) {
    this.transmission = transmission;
    return this;
  }
}
