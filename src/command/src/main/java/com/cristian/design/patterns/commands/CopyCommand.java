package com.cristian.design.patterns.commands;

import com.cristian.design.patterns.editor.Editor;

public class CopyCommand extends Command {

  public CopyCommand(final Editor editor) {
    super(editor);
  }

  @Override
  public boolean execute() {
    final String selectedText = this.getEditor().getTextField().getSelectedText();
    this.getEditor().setClipboard(selectedText);
    return false;
  }
}
