package com.cristian.design.patterns.store;

import com.cristian.design.patterns.action.Action;
import com.cristian.design.patterns.action.ActionType;
import com.cristian.design.patterns.action.Content;
import com.cristian.design.patterns.action.ContentAction;

import lombok.Getter;

@Getter
public class ContentStore extends Store {

  private Content content = Content.PRODUCTS;

  @Override
  public void onAction(final Action action) {
    if (action.getType().equals(ActionType.CONTENT_CHANGED)) {
      this.content = ((ContentAction) action).getContent();
      notifyChange();
    }
  }

}
