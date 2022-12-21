package com.cristian.design.patterns.example1.commands;

import com.cristian.design.patterns.example1.editor.Editor;

public class CutCommand extends Command {

  public CutCommand(final Editor editor) {
    super(editor);
  }

  @Override
  public boolean execute() {
    if (this.getEditor().getTextField().getSelectedText().isEmpty()) {
      return false;
    }

    this.backup();
    final String source = this.getEditor().getTextField().getText();
    this.getEditor().setClipboard(this.getEditor().getTextField().getSelectedText());
    this.getEditor().getTextField().setText(this.cutString(source));
    return true;
  }

  private String cutString(final String source) {
    final String start = source.substring(0, this.getEditor().getTextField().getSelectionStart());
    final String end = source.substring(this.getEditor().getTextField().getSelectionEnd());
    return start + end;
  }
}
