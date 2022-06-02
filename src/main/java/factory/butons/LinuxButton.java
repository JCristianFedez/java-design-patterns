package factory.butons;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LinuxButton implements Button {

  final JPanel panel = new JPanel();

  final JFrame frame = new JFrame();

  JButton button;

  @Override
  public void render() {
    final JLabel jLabel = new JLabel("Hello World!");
    jLabel.setOpaque(true);
    jLabel.setBackground(new Color(235, 233, 126));
    jLabel.setFont(new Font("Dialog", Font.BOLD, 44));
    jLabel.setHorizontalAlignment(SwingConstants.CENTER);

    this.panel.add(jLabel);
    this.panel.setLayout(new FlowLayout(FlowLayout.CENTER));

    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.frame.getContentPane().add(this.panel);

    this.onClick();
    this.panel.add(this.button);

    this.frame.setSize(320, 200);
    this.frame.setLocationRelativeTo(null);
    this.frame.setVisible(true);
    this.onClick();
  }

  @Override
  public void onClick() {
    this.button = new JButton("Exit");
    this.button.addActionListener(e -> {
      frame.setVisible(false);
      System.exit(0);
    });
  }
}
