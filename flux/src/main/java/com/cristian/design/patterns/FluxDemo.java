package com.cristian.design.patterns;

import com.cristian.design.patterns.action.MenuItem;
import com.cristian.design.patterns.dispatcher.Dispatcher;
import com.cristian.design.patterns.store.ContentStore;
import com.cristian.design.patterns.store.MenuStore;
import com.cristian.design.patterns.view.ContentView;
import com.cristian.design.patterns.view.MenuView;

public class FluxDemo {

  public static void main(String[] args) {
    new FluxDemo().run();
  }

  private void run() {
    final MenuStore menuStore = new MenuStore();
    Dispatcher.getInstance().registerStore(menuStore);
    final ContentStore contentStore = new ContentStore();
    Dispatcher.getInstance().registerStore(contentStore);

    final MenuView menuView = new MenuView();
    menuStore.registerView(menuView);
    final ContentView contentView = new ContentView();
    contentStore.registerView(contentView);

    menuView.render();
    contentView.render();

    menuView.itemClicked(MenuItem.COMPANY);
  }
}
