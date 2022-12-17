package com.cristian.design.patterns.commands;

import com.cristian.design.patterns.editor.Editor;

public abstract class Command {

  private final Editor editor;

  private String backup;

  Command(final Editor editor) {
    this.editor = editor;
  }

  void backup() {
    this.backup = editor.getTextField().getText();
  }

  public void undo() {
    this.editor.getTextField().setText(this.backup);
  }

  public abstract boolean execute();

  public Editor getEditor() {
    return this.editor;
  }
}
