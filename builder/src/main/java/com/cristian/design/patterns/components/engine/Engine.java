package com.cristian.design.patterns.components.engine;

public class Engine {

  private final double volume;

  private double mileage;

  private boolean started;

  public Engine(final double volume, final double mileage) {
    this.volume = volume;
    this.mileage = mileage;
  }

  public void on() {
    this.started = true;
  }

  public void off() {
    this.started = false;
  }

  public boolean isStarted() {
    return this.started;
  }

  public double getMileage() {
    return this.mileage;
  }

  public void setMileage(final double mileage) {
    this.mileage = mileage;
  }

  @Override
  public String toString() {
    return "Engine{" + "volume=" + volume + ", mileage=" + mileage + ", started=" + started + '}';
  }
}
