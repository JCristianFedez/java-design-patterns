package com.cristian.design.patterns.members;

import java.util.function.Consumer;

import com.cristian.design.patterns.data.DataType;

public interface Member extends Consumer<DataType> {

  void accept(DataType event);
}
