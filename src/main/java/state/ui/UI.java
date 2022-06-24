package state.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UI {

  private static final JTextField textField = new JTextField();

  private final Player player;

  public UI(final Player player) {
    this.player = player;
  }

  public void init() {
    final JFrame frame = new JFrame("Test player");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.createContext(frame);
    frame.setVisible(true);
    frame.setSize(300, 100);
  }

  private void createContext(final JFrame frame) {
    final JPanel context = new JPanel();
    context.setLayout(new BoxLayout(context, BoxLayout.Y_AXIS));
    context.add(textField);
    this.createButtons(context);
    frame.getContentPane().add(context);
  }

  private void createButtons(final JPanel context) {
    final JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
    this.addButtons(buttons);
    context.add(buttons);
  }

  /**
   * Delegados de contexto que manejan la entrada del usuario a un objeto de estado. Naturalmente, el resultado dependerá de qué estado esté
   * actualmente activo, ya que todos los estados pueden manejar la entrada de manera diferente.
   */
  private void addButtons(final JPanel panel) {
    panel.add(this.createButton("Play", e -> textField.setText(this.player.getState().onPlay())));
    panel.add(this.createButton("Stop", e -> textField.setText(this.player.getState().onLock())));
    panel.add(this.createButton("Next", e -> textField.setText(this.player.getState().onNext())));
    panel.add(this.createButton("Prev", e -> textField.setText(this.player.getState().onPrevious())));
  }

  private JButton createButton(final String title, final ActionListener actionButton) {
    final JButton button = new JButton(title);
    button.addActionListener(actionButton);
    return button;
  }
}
