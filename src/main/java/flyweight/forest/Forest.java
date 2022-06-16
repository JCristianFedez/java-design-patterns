package flyweight.forest;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import flyweight.trees.Tree;
import flyweight.trees.TreeFactory;
import flyweight.trees.TreeType;
import javax.swing.JFrame;

public class Forest extends JFrame {
  private final List<Tree> trees = new ArrayList<>();

  public void plantTree(final int cordX, final int cordY, final String name, Color color, final String otheTreeData) {
    final TreeType type = TreeFactory.getTreeType(name, color, otheTreeData);
    final Tree tree = new Tree(cordX, cordY, type);
    trees.add(tree);
  }

  @Override
  public void paint(final Graphics graphics) {
    this.trees.forEach(tree -> tree.draw(graphics));
  }
}
