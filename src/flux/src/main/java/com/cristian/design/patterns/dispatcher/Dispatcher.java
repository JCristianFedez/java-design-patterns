package com.cristian.design.patterns.dispatcher;

import java.util.LinkedList;
import java.util.List;

import com.cristian.design.patterns.action.Action;
import com.cristian.design.patterns.action.Content;
import com.cristian.design.patterns.action.ContentAction;
import com.cristian.design.patterns.action.MenuAction;
import com.cristian.design.patterns.action.MenuItem;
import com.cristian.design.patterns.store.Store;

public class Dispatcher {

  private static final Dispatcher INSTANCE = new Dispatcher();

  private final List<Store> stores = new LinkedList<>();

  private Dispatcher() {
  }

  public static Dispatcher getInstance() {
    return INSTANCE;
  }

  public void registerStore(final Store store) {
    this.stores.add(store);
  }

  public void menuItemSelected(final MenuItem menuItem) {
    dispatchAction(new MenuAction(menuItem));
    if (MenuItem.COMPANY.equals(menuItem)) {
      dispatchAction(new ContentAction(Content.COMPANY));
    } else {
      dispatchAction(new ContentAction(Content.PRODUCTS));
    }
  }

  private void dispatchAction(final Action action) {
    this.stores.forEach(store -> store.onAction(action));
  }
}
