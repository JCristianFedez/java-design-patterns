package com.cristian.design.patterns.example1.commands;

import com.cristian.design.patterns.example1.editor.Editor;

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
