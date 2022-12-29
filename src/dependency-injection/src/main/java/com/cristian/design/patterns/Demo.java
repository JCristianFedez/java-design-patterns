package com.cristian.design.patterns;

class Demo {

  public static void main(String[] args) {
    new AdvanceWizard(new SecondBreakfastTobacco()).smoke();
    new AdvanceWizard(new OldTobyTobacco()).smoke();
    new AdvanceWizard(new RivendellTobacco()).smoke();
    new GuiceWizard(new SecondBreakfastTobacco()).smoke();
    new GuiceWizard(new OldTobyTobacco()).smoke();
    new GuiceWizard(new RivendellTobacco()).smoke();
  }
}
