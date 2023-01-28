package com.cristian.design.patterns.view;

import com.cristian.design.patterns.action.MenuItem;
import com.cristian.design.patterns.dispatcher.Dispatcher;
import com.cristian.design.patterns.store.MenuStore;
import com.cristian.design.patterns.store.Store;

public class MenuView implements View {

  private MenuItem selected = MenuItem.HOME;

  @Override
  public void storeChanged(final Store store) {
    this.selected = ((MenuStore) store).getSelected();
    render();
  }

  @Override
  public void render() {
    for (final MenuItem item : MenuItem.values()) {
      if (item.equals(this.selected)) {
        System.out.printf("* %s%n", item);
      } else {
        System.out.println(item);
      }
    }
  }

  public void itemClicked(final MenuItem item) {
    Dispatcher.getInstance().menuItemSelected(item);
  }
}
