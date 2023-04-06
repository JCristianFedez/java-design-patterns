package com.cristian.design.patterns;

import com.cristian.design.patterns.models.HalflingThief;
import com.cristian.design.patterns.stealing.methods.HitAndRunMethod;
import com.cristian.design.patterns.stealing.methods.SubtleMethod;

public class TemplateMethodDemo02 {

  public static void main(String[] args) {
    final HalflingThief thief = new HalflingThief(new HitAndRunMethod());
    thief.steal();
    thief.changeMethod(new SubtleMethod());
    thief.steal();
  }
}
