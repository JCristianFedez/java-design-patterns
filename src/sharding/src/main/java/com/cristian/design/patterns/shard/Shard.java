package com.cristian.design.patterns.shard;

import java.util.HashMap;
import java.util.Map;

import com.cristian.design.patterns.Data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Shard {

  @Getter
  private final int id;

  private final Map<Integer, Data> dataStore = new HashMap<>();

  public void storeData(final Data newData) {
    this.dataStore.put(newData.getKey(), newData);
  }

  public void clearData() {
    this.dataStore.clear();
  }

  public Data dataById(final int id) {
    return this.dataStore.get(id);
  }
}
