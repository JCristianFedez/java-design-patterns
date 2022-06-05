package composite.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class CompoundShape extends BaseShape {

  protected List<Shape> children = new ArrayList<>();

  public CompoundShape(Shape... components) {
    super(0, 0, Color.BLACK);
    this.add(components);
  }

  public void add(Shape... components) {
    this.children.addAll(Arrays.asList(components));
  }

  public void remove(Shape... components) {
    this.children.removeAll(Arrays.asList(components));
  }

  public void clear() {
    this.children.clear();
  }

  @Override
  public int getX() {
    return this.getMaxCord(Shape::getX);
  }

  @Override
  public int getY() {
    return this.getMaxCord(Shape::getY);
  }

  private int getMaxCord(final Function<Shape, Integer> getCord) {
    return this.children.stream().map(getCord).max(Comparator.naturalOrder()).orElse(0);
  }

  @Override
  public void move(int x, int y) {
    this.children.forEach(child -> child.move(x, y));
  }

  @Override
  public boolean isInsideBounds(int x, int y) {
    return this.children.stream().anyMatch(child -> child.isInsideBounds(x, y));
  }

  @Override
  public void unSelect() {
    super.unSelect();
    this.children.forEach(Shape::unSelect);
  }

  public void selectChildAt(int x, int y) {
    this.children.stream().filter(child -> child.isInsideBounds(x, y)).findFirst().ifPresent(Shape::select);
  }

  @Override
  public void paint(Graphics graphics) {
    if (this.isSelected()) {
      enableSelectionStyle(graphics);
      graphics.drawRect(this.getX() - 1, this.getY() - 1, this.getWidth() + 1, this.getHeight() + 1);
      disableSelectionStyle(graphics);
    }

    this.children.forEach(child -> child.paint(graphics));
  }
}
