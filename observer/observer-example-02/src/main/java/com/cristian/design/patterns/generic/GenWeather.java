package com.cristian.design.patterns.generic;

import com.cristian.design.patterns.models.weather.WeatherType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenWeather extends Observable<GenWeather, Race, WeatherType> {

  private WeatherType currentWeather = WeatherType.SUNNY;

  public void timePasses() {
    final WeatherType[] enumValues = WeatherType.values();
    this.currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
    LOGGER.info("The weather changed to {}.", this.currentWeather);
    notifyObservers(this.currentWeather);
  }
}
