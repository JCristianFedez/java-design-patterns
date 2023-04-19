package com.cristian.design.patterns.view;

import com.cristian.design.patterns.action.Content;
import com.cristian.design.patterns.store.ContentStore;
import com.cristian.design.patterns.store.Store;

public class ContentView implements View {

  private Content content = Content.PRODUCTS;

  @Override
  public void storeChanged(final Store store) {
    this.content = ((ContentStore) store).getContent();
    render();
  }

  @Override
  public void render() {
    System.out.println(this.content);
  }
}
