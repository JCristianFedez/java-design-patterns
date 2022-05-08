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
  public void setCarType(final CarType carType) {
    this.carType = carType;
  }

  public int getSeats() {
    return seats;
  }

  @Override
  public void setSeats(final int seats) {
    this.seats = seats;
  }

  public Engine getEngine() {
    return engine;
  }

  @Override
  public void setEngine(final Engine engine) {
    this.engine = engine;
  }

  public Transmission getTransmission() {
    return transmission;
  }

  @Override
  public void setTransmission(final Transmission transmission) {
    this.transmission = transmission;
  }
}
