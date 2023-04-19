package com.cristian.design.patterns.models.weather;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Weather {

  private final List<WeatherObserver> observers = new ArrayList<>();

  private WeatherType currentWeather = WeatherType.SUNNY;

  public void addObserver(final WeatherObserver observer) {
    this.observers.add(observer);
  }

  public void removeObserver(final WeatherObserver observer) {
    this.observers.remove(observer);
  }

  public void timePasses() {
    final WeatherType[] enumValues = WeatherType.values();
    this.currentWeather = enumValues[(this.currentWeather.ordinal() + 1) % enumValues.length];
    LOGGER.info("The weather changed to {}", this.currentWeather);

    notifyObservers();
  }

  private void notifyObservers() {
    this.observers.forEach(observer -> observer.update(this.currentWeather));
  }
}
