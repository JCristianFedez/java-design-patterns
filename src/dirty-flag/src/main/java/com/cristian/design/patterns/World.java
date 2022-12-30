package com.cristian.design.patterns;

import java.util.ArrayList;
import java.util.List;

class World {

  private final List<String> countries = new ArrayList<>();

  private final DataFetcher dataFetcher = new DataFetcher();

  public List<String> fetch() {
    final List<String> data = this.dataFetcher.fetch();
    if (!data.isEmpty()) {
      this.countries.clear();
      this.countries.addAll(data);
    }
    return this.countries;
  }
}
