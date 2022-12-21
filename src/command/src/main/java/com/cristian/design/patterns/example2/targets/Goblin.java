package com.cristian.design.patterns.example2.targets;

import com.cristian.design.patterns.example2.Size;
import com.cristian.design.patterns.example2.Visibility;

public class Goblin extends Target {

  public Goblin() {
    super(Size.NORMAL, Visibility.VISIBLE);
  }

  @Override
  public String toString() {
    return "Goblin";
  }

  public void changeSize() {
    final Size newSize = Size.NORMAL.equals(getSize()) ? Size.SMALL : Size.NORMAL;
    setSize(newSize);
  }

  public void changeVisibility() {
    final Visibility newVisibility = Visibility.VISIBLE.equals(getVisibility()) ? Visibility.INVISIBLE : Visibility.VISIBLE;
    setVisibility(newVisibility);
  }
}
