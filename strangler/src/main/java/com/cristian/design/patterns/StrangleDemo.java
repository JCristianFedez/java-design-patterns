package com.cristian.design.patterns;

import com.cristian.design.patterns.arithmetic.HalfArithmetic;
import com.cristian.design.patterns.arithmetic.NewArithmetic;
import com.cristian.design.patterns.arithmetic.OldArithmetic;
import com.cristian.design.patterns.source.HalfSource;
import com.cristian.design.patterns.source.NewSource;
import com.cristian.design.patterns.source.OldSource;

public class StrangleDemo {

  public static void main(String[] args) {
    final int[] nums = new int[]{1, 2, 3, 4, 5};

    // Before migration
    final OldArithmetic oldSystem = new OldArithmetic(new OldSource());
    oldSystem.sum(nums);
    oldSystem.mul(nums);

    // In process of migration
    final HalfArithmetic halfSystem = new HalfArithmetic(new HalfSource(), new OldSource());
    halfSystem.sum(nums);
    halfSystem.mul(nums);
    halfSystem.ifHasZero(nums);

    // After migration
    final NewArithmetic newSystem = new NewArithmetic(new NewSource());
    newSystem.sum(nums);
    newSystem.mul(nums);
    newSystem.ifHasZero(nums);
  }
}
