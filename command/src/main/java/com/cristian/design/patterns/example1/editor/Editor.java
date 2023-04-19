package com.cristian.design.patterns.example1.editor;

import java.awt.FlowLayout;

import com.cristian.design.patterns.example1.commands.Command;
import com.cristian.design.patterns.example1.commands.CommandHistory;
import com.cristian.design.patterns.example1.commands.CopyCommand;
import com.cristian.design.patterns.example1.commands.CutCommand;
import com.cristian.design.patterns.example1.commands.PasteCommand;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Editor {

  private final CommandHistory history = new CommandHistory();

  private JTextArea textField;

  private String clipboard;

  public void init() {
    final JFrame frame = new JFrame("Editor de texto ¡Escribe y usa botones!");
    final JPanel content = new JPanel();
    frame.setContentPane(content);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
    this.textField = new JTextArea();
    this.textField.setLineWrap(true);
    content.add(textField);
    final JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    final JButton ctrlC = new JButton("Ctrl+C");
    final JButton ctrlX = new JButton("Ctrl+X");
    final JButton ctrlV = new JButton("Ctrl+V");
    final JButton ctrlZ = new JButton("Ctrl+Z");
    final Editor editor = this;

    ctrlC.addActionListener(e -> executeCommand(new CopyCommand(editor)));
    ctrlX.addActionListener(e -> executeCommand(new CutCommand(editor)));
    ctrlV.addActionListener(e -> executeCommand(new PasteCommand(editor)));
    ctrlZ.addActionListener(e -> undo());

    buttons.add(ctrlC);
    buttons.add(ctrlX);
    buttons.add(ctrlV);
    buttons.add(ctrlZ);
    content.add(buttons);
    frame.setSize(450, 200);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }

  private void executeCommand(final Command command) {
    if (command.execute()) {
      this.history.push(command);
    }
  }

  private void undo() {
    if (this.history.isEmpty()) {
      return;
    }

    final Command command = this.history.pop();
    if (command != null) {
      command.undo();
    }
  }

  public JTextArea getTextField() {
    return textField;
  }

  public String getClipboard() {
    return clipboard;
  }

  public void setClipboard(final String clipboard) {
    this.clipboard = clipboard;
  }
}
