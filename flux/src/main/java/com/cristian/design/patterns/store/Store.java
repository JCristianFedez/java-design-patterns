package com.cristian.design.patterns.store;

import java.util.LinkedList;
import java.util.List;

import com.cristian.design.patterns.action.Action;
import com.cristian.design.patterns.view.View;

public abstract class Store {

  private final List<View> views = new LinkedList<>();

  public abstract void onAction(final Action action);

  public void registerView(final View view) {
    this.views.add(view);
  }

  protected void notifyChange() {
    this.views.forEach(view -> view.storeChanged(this));
  }
}
