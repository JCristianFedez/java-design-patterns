package builder.cars.builder;

import builder.cars.CarType;
import builder.components.engine.Engine;
import builder.components.transmission.Transmission;

interface Builder {

  void setCarType(final CarType carType);

  void setSeats(final int seats);

  void setEngine(final Engine engine);

  void setTransmission(final Transmission transmission);

}
