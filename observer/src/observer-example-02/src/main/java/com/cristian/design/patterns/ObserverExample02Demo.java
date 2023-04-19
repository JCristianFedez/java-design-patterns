package com.cristian.design.patterns;

import com.cristian.design.patterns.generic.GenHobbits;
import com.cristian.design.patterns.generic.GenOrcs;
import com.cristian.design.patterns.generic.GenWeather;
import com.cristian.design.patterns.models.Hobbits;
import com.cristian.design.patterns.models.Orcs;
import com.cristian.design.patterns.models.weather.Weather;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObserverExample02Demo {

  public static void main(String[] args) {
    new ObserverExample02Demo().run();
  }

  private void run() {
    final Weather weather = new Weather();
    weather.addObserver(new Orcs());
    weather.addObserver(new Hobbits());

    weather.timePasses();
    weather.timePasses();
    weather.timePasses();
    weather.timePasses();

    // Generic observer inspired by Java Generics and Collections by Naftalin & Wadler
    LOGGER.info("--Running generic version--");
    final GenWeather genericWeather = new GenWeather();
    genericWeather.addObserver(new GenOrcs());
    genericWeather.addObserver(new GenHobbits());

    genericWeather.timePasses();
    genericWeather.timePasses();
    genericWeather.timePasses();
    genericWeather.timePasses();
  }
}
