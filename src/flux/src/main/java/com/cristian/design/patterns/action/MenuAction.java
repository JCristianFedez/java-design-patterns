package com.cristian.design.patterns.action;

import lombok.Getter;

public class MenuAction extends Action {

  @Getter
  private final MenuItem menuItem;

  public MenuAction(final MenuItem menuItem) {
    super(ActionType.MENU_ITEM_SELECTED);
    this.menuItem = menuItem;
  }
}
