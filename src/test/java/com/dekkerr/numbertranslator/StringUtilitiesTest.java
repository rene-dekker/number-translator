package com.dekkerr.numbertranslator;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dekkerr.numbertranslator.util.StringUtilities.capitalizeFirstCharacter;
import static com.dekkerr.numbertranslator.util.StringUtilities.concat;
import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilitiesTest {

  @Test
  public void testCapitalizeFirstCharacter_null() {
    assertThat(capitalizeFirstCharacter(null)).isNull();
  }

  @Test
  public void testCapitalizeFirstCharacter_empty() {
    assertThat(capitalizeFirstCharacter("")).isEmpty();
  }

  @Test
  public void testCapitalizeFirstCharacter_regular() {
    assertThat(capitalizeFirstCharacter("pancake")).isEqualTo("Pancake");
    assertThat(capitalizeFirstCharacter("pancake with maple syrup")).isEqualTo("Pancake with maple syrup");
  }

  @Test
  public void testCapitalizeFirstCharacter_upper() {
    assertThat(capitalizeFirstCharacter("PANCAKE")).isEqualTo("Pancake");
  }

  @Test
  public void testCapitalizeFirstCharacter_1Char() {
    assertThat(capitalizeFirstCharacter("p")).isEqualTo("P");
  }

  @Test
  public void testConcat_empty() {
    List<String> numberParts = new ArrayList<>();
    assertThat(concat(numberParts, true, false)).isEqualTo("");
  }

  @Test
  public void testConcat_null() {
    List<String> numberParts = null;
    assertThat(concat(numberParts, true, false)).isEqualTo(null);
  }

  @Test
  public void testConcat_1part() {
    List<String> numberParts = Lists.list("two hundred");
    assertThat(concat(numberParts, true, false)).isEqualTo("two hundred");
  }

  @Test
  public void testConcat_1part_negative() {
    List<String> numberParts = Lists.list("two hundred");
    assertThat(concat(numberParts, true, true)).isEqualTo("minus two hundred");
  }

  @Test
  public void testConcat_2parts() {
    List<String> numberParts = Lists.list("two hundred", "twenty five");
    assertThat(concat(numberParts, true, false)).isEqualTo("two hundred and twenty five");
  }

  @Test
  public void testConcat_2parts_false() {
    List<String> numberParts = Lists.list("two hundred", "twenty five");
    assertThat(concat(numberParts, false, false)).isEqualTo("two hundred twenty five");
  }

  @Test
  public void testConcat_more_parts_false() {
    List<String> numberParts = Lists.list("five thousand", "two hundred", "twenty five");
    assertThat(concat(numberParts, false, false)).isEqualTo("five thousand two hundred twenty five");
  }

  @Test
  public void testConcat_more_parts_true() {
    List<String> numberParts = Lists.list("five thousand", "two hundred", "twenty five");
    assertThat(concat(numberParts, true, false)).isEqualTo("five thousand two hundred and twenty five");
  }
}
