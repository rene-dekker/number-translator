package com.dekkerr.numbertranslator.service;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersBelowTwentyTest {

  @Test(expected = IllegalArgumentException.class)
  public void testForInteger_zero() {
    NumbersBelowTwenty.ofIntValue(0);
  }


  @Test(expected = IllegalArgumentException.class)
  public void testForInteger_bad() {
    NumbersBelowTwenty.ofIntValue(45);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForInteger_negative() {
    NumbersBelowTwenty.ofIntValue(-2);
  }

  @Test
  public void testForInteger_all() {
    assertThat(NumbersBelowTwenty.ofIntValue(1).getStringValue()).isEqualTo("one");
    assertThat(NumbersBelowTwenty.ofIntValue(2).getStringValue()).isEqualTo("two");
    assertThat(NumbersBelowTwenty.ofIntValue(3).getStringValue()).isEqualTo("three");
    assertThat(NumbersBelowTwenty.ofIntValue(4).getStringValue()).isEqualTo("four");
    assertThat(NumbersBelowTwenty.ofIntValue(5).getStringValue()).isEqualTo("five");
    assertThat(NumbersBelowTwenty.ofIntValue(6).getStringValue()).isEqualTo("six");
    assertThat(NumbersBelowTwenty.ofIntValue(7).getStringValue()).isEqualTo("seven");
    assertThat(NumbersBelowTwenty.ofIntValue(8).getStringValue()).isEqualTo("eight");
    assertThat(NumbersBelowTwenty.ofIntValue(9).getStringValue()).isEqualTo("nine");
    assertThat(NumbersBelowTwenty.ofIntValue(10).getStringValue()).isEqualTo("ten");

    assertThat(NumbersBelowTwenty.ofIntValue(11).getStringValue()).isEqualTo("eleven");
    assertThat(NumbersBelowTwenty.ofIntValue(12).getStringValue()).isEqualTo("twelve");
    assertThat(NumbersBelowTwenty.ofIntValue(13).getStringValue()).isEqualTo("thirteen");
    assertThat(NumbersBelowTwenty.ofIntValue(14).getStringValue()).isEqualTo("fourteen");
    assertThat(NumbersBelowTwenty.ofIntValue(15).getStringValue()).isEqualTo("fifteen");
    assertThat(NumbersBelowTwenty.ofIntValue(16).getStringValue()).isEqualTo("sixteen");
    assertThat(NumbersBelowTwenty.ofIntValue(17).getStringValue()).isEqualTo("seventeen");
    assertThat(NumbersBelowTwenty.ofIntValue(18).getStringValue()).isEqualTo("eighteen");
    assertThat(NumbersBelowTwenty.ofIntValue(19).getStringValue()).isEqualTo("nineteen");
  }
}
