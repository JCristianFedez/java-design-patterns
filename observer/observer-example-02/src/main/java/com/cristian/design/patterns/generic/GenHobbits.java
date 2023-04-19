package com.cristian.design.patterns.generic;

import com.cristian.design.patterns.models.weather.WeatherType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenHobbits implements Race {

  @Override
  public void update(GenWeather weather, WeatherType weatherType) {
    LOGGER.info("The hobbits are facing " + weatherType + " weather now");
  }
}
