package com.cristian.design.patterns.view;

import com.cristian.design.patterns.store.Store;

public interface View {

  void storeChanged(Store store);

  void render();
}
