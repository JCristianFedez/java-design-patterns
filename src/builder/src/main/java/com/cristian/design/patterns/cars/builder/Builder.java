package com.cristian.design.patterns.cars.builder;

import com.cristian.design.patterns.cars.CarType;
import com.cristian.design.patterns.components.engine.Engine;
import com.cristian.design.patterns.components.transmission.Transmission;

public interface Builder {

  CarBuilder setCarType(final CarType carType);

  CarBuilder setSeats(final int seats);

  CarBuilder setEngine(final Engine engine);

  CarBuilder setTransmission(final Transmission transmission);

}
