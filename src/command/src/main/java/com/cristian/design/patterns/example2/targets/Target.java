package com.cristian.design.patterns.example2.targets;

import com.cristian.design.patterns.example2.Size;
import com.cristian.design.patterns.example2.Visibility;
import com.cristian.design.patterns.logger.Logger;

abstract class Target {

  private static final Logger LOGGER = Logger.fromType(Target.class);

  private Size size;

  private Visibility visibility;

  protected Target(final Size size, final Visibility visibility) {
    this.size = size;
    this.visibility = visibility;
  }

  public Size getSize() {
    return this.size;
  }

  public void setSize(final Size size) {
    this.size = size;
  }

  public Visibility getVisibility() {
    return this.visibility;
  }

  public void setVisibility(final Visibility visibility) {
    this.visibility = visibility;
  }

  @Override
  public abstract String toString();

  public void printStatus() {
    LOGGER.info("%s, [size=%s] [visibility=%s]", this, getSize(), getVisibility());
  }
}
