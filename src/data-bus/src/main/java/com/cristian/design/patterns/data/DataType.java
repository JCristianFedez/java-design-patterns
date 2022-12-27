package com.cristian.design.patterns.data;

import com.cristian.design.patterns.DataBus;

public interface DataType {

  DataBus getDataBus();

  void setDataBus(DataBus dataBus);
}
