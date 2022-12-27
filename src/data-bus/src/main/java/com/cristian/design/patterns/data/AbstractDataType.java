package com.cristian.design.patterns.data;

import com.cristian.design.patterns.DataBus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractDataType implements DataType {
  private DataBus dataBus;
}
