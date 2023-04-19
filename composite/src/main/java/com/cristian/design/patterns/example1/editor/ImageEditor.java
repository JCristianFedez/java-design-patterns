package com.cristian.design.patterns.example1.editor;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.cristian.design.patterns.example1.shapes.CompoundShape;
import com.cristian.design.patterns.example1.shapes.Shape;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class ImageEditor {

  private final EditorCanvas canvas;

  private final CompoundShape allShapes = new CompoundShape();

  public ImageEditor() {
    this.canvas = new EditorCanvas();
  }

  public void loadShapes(Shape... shapes) {
    this.allShapes.clear();
    this.allShapes.add(shapes);
    this.canvas.refresh();
  }

  private class EditorCanvas extends Canvas {

    private static final int PADDING = 10;

    private JFrame frame;

    EditorCanvas() {
      createFrame();
      refresh();
      addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
          allShapes.unSelect();
          allShapes.selectChildAt(e.getX(), e.getY());
          e.getComponent().repaint();
        }
      });
    }

    void createFrame() {
      this.frame = new JFrame();
      this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      this.frame.setLocationRelativeTo(null);

      final JPanel contentPanel = new JPanel();
      final Border padding = BorderFactory.createEmptyBorder(PADDING, PADDING, PADDING, PADDING);
      contentPanel.setBorder(padding);
      this.frame.setContentPane(contentPanel);

      this.frame.add(this);
      this.frame.setVisible(true);
      this.frame.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public int getWidth() {
      return allShapes.getCordX() + allShapes.getWidth() + PADDING;
    }

    @Override
    public int getHeight() {
      return allShapes.getCordY() + allShapes.getHeight() + PADDING;
    }

    void refresh() {
      this.setSize(getWidth(), getHeight());
      frame.pack();
    }

    @Override
    public void paint(Graphics graphics) {
      allShapes.paint(graphics);
    }
  }
}