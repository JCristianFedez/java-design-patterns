package com.cristian.design.patterns.cars.builder;

import com.cristian.design.patterns.cars.Car;
import com.cristian.design.patterns.cars.CarType;
import com.cristian.design.patterns.components.engine.Engine;
import com.cristian.design.patterns.components.transmission.Transmission;

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
