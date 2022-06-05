package composite.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class BaseShape implements Shape {

  private final Color color;

  private boolean selected = false;

  private int x;

  private int y;

  public BaseShape(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }

  @Override
  public void move(int x, int y) {
    this.x += x;
    this.y += y;
  }

  @Override
  public boolean isInsideBounds(int x, int y) {
    return this.x > this.getX() && this.getX() < (this.getX() + this.getWidth())
        && this.y > this.getY() && this.getY() < (this.getY() + this.getHeight());
  }

  @Override
  public void select() {
    this.selected = true;
  }

  @Override
  public void unSelect() {
    this.selected = false;
  }

  @Override
  public boolean isSelected() {
    return this.selected;
  }

  @Override
  public void paint(Graphics graphics) {
    if (this.isSelected()) {
      this.enableSelectionStyle(graphics);
    } else {
      this.disableSelectionStyle(graphics);
    }
  }

  void enableSelectionStyle(final Graphics graphics) {
    graphics.setColor(Color.LIGHT_GRAY);

    final Graphics2D g2 = (Graphics2D) graphics;
    final float[] dash1 = {2.0f};
    g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 2.0f, dash1, 0.0f));
  }

  void disableSelectionStyle(Graphics graphics) {
    graphics.setColor(this.color);
    final Graphics2D g2 = (Graphics2D) graphics;
    g2.setStroke(new BasicStroke());
  }
}
