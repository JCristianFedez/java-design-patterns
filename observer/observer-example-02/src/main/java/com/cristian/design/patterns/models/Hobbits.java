package com.cristian.design.patterns.models;

import com.cristian.design.patterns.models.weather.WeatherObserver;
import com.cristian.design.patterns.models.weather.WeatherType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hobbits implements WeatherObserver {

  @Override
  public void update(final WeatherType currentWeather) {
    LOGGER.info("The hobbits are facing {} weather now", currentWeather);
  }
}
