package flyweight.trees;

import java.awt.Color;
import java.awt.Graphics;

public class TreeType {

  private final String name;

  private final Color color;

  private final String otherTreeData;

  public TreeType(final String name, final Color color, final String otherTreeData) {
    this.name = name;
    this.color = color;
    this.otherTreeData = otherTreeData;
  }

  public void draw(final Graphics graphics, final int cordX, final int cordY) {
    graphics.setColor(Color.BLACK);
    graphics.fillRect(cordX - 1, cordY, 3, 5);
    graphics.setColor(this.color);
    graphics.fillOval(cordX - 5, cordY - 10, 10, 10);
  }
}
