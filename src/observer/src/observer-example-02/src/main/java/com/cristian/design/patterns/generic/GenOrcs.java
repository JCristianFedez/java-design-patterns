package com.cristian.design.patterns.generic;

import com.cristian.design.patterns.models.weather.WeatherType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenOrcs implements Race {

  @Override
  public void update(GenWeather weather, WeatherType weatherType) {
    LOGGER.info("The orcs are facing " + weatherType + " weather now");
  }
}
