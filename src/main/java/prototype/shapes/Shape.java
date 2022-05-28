package prototype.shapes;

import java.util.Objects;

public abstract class Shape {

  private int x;

  private int y;

  private String color;

  public Shape() {
  }

  public Shape(final Shape target) {
    if (target != null) {
      this.x = target.x;
      this.y = target.y;
      this.color = target.color;
    }
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public abstract Shape clone();

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Shape)) {
      return false;
    }
    Shape shape = (Shape) o;
    return x == shape.x && y == shape.y && Objects.equals(color, shape.color);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y, color);
  }
}
