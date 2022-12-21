package com.cristian.design.patterns.example1.commands;

import com.cristian.design.patterns.example1.editor.Editor;

public class PasteCommand extends Command {

  public PasteCommand(final Editor editor) {
    super(editor);
  }

  @Override
  public boolean execute() {
    final String clipboard = this.getEditor().getClipboard();
    if (clipboard == null || clipboard.isEmpty()) {
      return false;
    }

    this.backup();
    this.getEditor().getTextField().insert(clipboard, this.getEditor().getTextField().getCaretPosition());
    return true;
  }
}
