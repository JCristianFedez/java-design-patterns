package com.cristian.design.patterns.action;

import lombok.Getter;

@Getter
public class ContentAction extends Action {

  private final Content content;

  public ContentAction(final Content content) {
    super(ActionType.CONTENT_CHANGED);
    this.content = content;
  }
}
