package com.cristian.design.patterns;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class CoarseGrainedObject<T> {

  List<DependentObject<T>> dependentObjects;

  public List<T> getData() {
    return this.dependentObjects.stream().map(DependentObject::getData).collect(Collectors.toList());
  }

  public void setData(List<T> datas) {
    IntStream.range(0, datas.size()).forEach(i -> this.dependentObjects.get(i).setData(datas.get(i)));
  }
}
