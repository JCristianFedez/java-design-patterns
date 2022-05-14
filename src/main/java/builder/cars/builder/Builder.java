package builder.cars.builder;

import builder.cars.CarType;
import builder.components.engine.Engine;
import builder.components.transmission.Transmission;

interface Builder {

  CarBuilder setCarType(final CarType carType);

  CarBuilder setSeats(final int seats);

  CarBuilder setEngine(final Engine engine);

  CarBuilder setTransmission(final Transmission transmission);

}
