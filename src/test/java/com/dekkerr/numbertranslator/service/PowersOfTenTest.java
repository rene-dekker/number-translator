package com.dekkerr.numbertranslator.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PowersOfTenTest {

  /**
   * The code will cease to work once the enum values are no longer in descending order.
   */
  @Test
  public void testDescendingOrder() {
    long previous = Long.MAX_VALUE;
    for (PowersOfTen value : PowersOfTen.values()) {
      assertThat(value.getLongValue()).isLessThan(previous);
      previous = value.getLongValue();
    }
  }

  @Test
  public void testValuesCorrespond() {
    for (PowersOfTen value : PowersOfTen.values()) {
      assertThat(value.getLongValue() / Math.pow(10, value.getLogBase())).isEqualTo(1);
    }
  }
}
