package com.cristian.design.patterns;

import com.cristian.design.patterns.models.Mammoth;

public class StateDemo02 {

  public static void main(String[] args) {
    final Mammoth mammoth = new Mammoth();
    mammoth.observe();
    mammoth.timePasses();
    mammoth.observe();
    mammoth.timePasses();
    mammoth.observe();
  }
}
