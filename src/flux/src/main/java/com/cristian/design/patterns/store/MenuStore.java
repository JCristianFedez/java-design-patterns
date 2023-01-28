package com.cristian.design.patterns.store;

import com.cristian.design.patterns.action.Action;
import com.cristian.design.patterns.action.ActionType;
import com.cristian.design.patterns.action.MenuAction;
import com.cristian.design.patterns.action.MenuItem;

import lombok.Getter;

@Getter
public class MenuStore extends Store {

  private MenuItem selected = MenuItem.HOME;

  @Override
  public void onAction(final Action action) {
    if (action.getType().equals(ActionType.MENU_ITEM_SELECTED)) {
      this.selected = ((MenuAction) action).getMenuItem();
      notifyChange();
    }
  }
}