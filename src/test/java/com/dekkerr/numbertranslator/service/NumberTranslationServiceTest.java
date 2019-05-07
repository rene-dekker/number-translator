package com.dekkerr.numbertranslator.service;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTranslationServiceTest {

  private NumberTranslationServiceImpl service;

  @Before
  public void setup() {
    this.service = new NumberTranslationServiceImpl();
  }

  @Test
  public void translate_testcases_from_requirements() {
    // 0    //Zero
    //13    //Thirteen
    //85    //Eighty five
    //5237  //Five thousand two hundred and thirty seven
    assertThat(this.service.translate(0)).isEqualTo("Zero");
    assertThat(this.service.translate(13)).isEqualTo("Thirteen");
    assertThat(this.service.translate(85)).isEqualTo("Eighty five");
    assertThat(this.service.translate(5237)).isEqualTo("Five thousand two hundred and thirty seven");
  }

  @Test
  public void translate_MinLongValue() {
    assertThat(this.service.translate(Long.MIN_VALUE)).isEqualTo("Minus nine quintillion two hundred and twenty three quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four million seven hundred and seventy five thousand eight hundred and eight");
  }

  @Test
  public void translate_MinLongValue_no_caps() {
    assertThat(this.service.translate(Long.MIN_VALUE, false)).isEqualTo("minus nine quintillion two hundred and twenty three quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four million seven hundred and seventy five thousand eight hundred and eight");
  }

  @Test
  public void translate_MinLongValuePlus1() {
    long testValue = Long.MIN_VALUE + 1;
    assertThat(this.service.translate(testValue)).isEqualTo("Minus nine quintillion two hundred and twenty three quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four million seven hundred and seventy five thousand eight hundred and seven");
  }

  @Test
  public void translate_MaxLongValue() {
    assertThat(this.service.translate(Long.MAX_VALUE)).isEqualTo("Nine quintillion two hundred and twenty three quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four million seven hundred and seventy five thousand eight hundred and seven");
  }

  @Test
  public void translate_zero() {
    assertThat(this.service.translate(0)).isEqualTo("Zero");
  }

  @Test
  public void translate_various() {
    // Some values below 20
    assertThat(this.service.translate(5)).isEqualTo("Five");
    assertThat(this.service.translate(11)).isEqualTo("Eleven");
    assertThat(this.service.translate(19)).isEqualTo("Nineteen");

    // Some values between 20-100
    assertThat(this.service.translate(20)).isEqualTo("Twenty");
    assertThat(this.service.translate(21)).isEqualTo("Twenty one");
    assertThat(this.service.translate(99)).isEqualTo("Ninety nine");

    // Some values to check if the word "and" is in the right place
    assertThat(this.service.translate(101)).isEqualTo("One hundred and one");
    assertThat(this.service.translate(1001)).isEqualTo("One thousand and one");
    assertThat(this.service.translate(1015)).isEqualTo("One thousand and fifteen");

    // More values
    assertThat(this.service.translate(100)).isEqualTo("One hundred");
    assertThat(this.service.translate(251)).isEqualTo("Two hundred and fifty one");
    assertThat(this.service.translate(251_251)).isEqualTo("Two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(251_251_251)).isEqualTo("Two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(251_251_251_251L)).isEqualTo("Two hundred and fifty one billion two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(251_251_251_251_251L)).isEqualTo("Two hundred and fifty one trillion two hundred and fifty one billion two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(251_251_251_251_251_251L)).isEqualTo("Two hundred and fifty one quadrillion two hundred and fifty one trillion two hundred and fifty one billion two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(2_251_251_251_251_251_251L)).isEqualTo("Two quintillion two hundred and fifty one quadrillion two hundred and fifty one trillion two hundred and fifty one billion two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
  }


  @Test
  public void translate_various_negative() {
    // Some values below 20
    assertThat(this.service.translate(-5)).isEqualTo("Minus five");
    assertThat(this.service.translate(-11)).isEqualTo("Minus eleven");
    assertThat(this.service.translate(-19)).isEqualTo("Minus nineteen");

    // Some values between 20-100
    assertThat(this.service.translate(-20)).isEqualTo("Minus twenty");
    assertThat(this.service.translate(-21)).isEqualTo("Minus twenty one");
    assertThat(this.service.translate(-99)).isEqualTo("Minus ninety nine");

    // Some values to check if the word "and" is in the right place
    assertThat(this.service.translate(-101)).isEqualTo("Minus one hundred and one");
    assertThat(this.service.translate(-1001)).isEqualTo("Minus one thousand and one");
    assertThat(this.service.translate(-1015)).isEqualTo("Minus one thousand and fifteen");

    // More values
    assertThat(this.service.translate(-100)).isEqualTo("Minus one hundred");
    assertThat(this.service.translate(-251)).isEqualTo("Minus two hundred and fifty one");
    assertThat(this.service.translate(-251_251)).isEqualTo("Minus two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(-251_251_251)).isEqualTo("Minus two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(-251_251_251_251L)).isEqualTo("Minus two hundred and fifty one billion two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(-251_251_251_251_251L)).isEqualTo("Minus two hundred and fifty one trillion two hundred and fifty one billion two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(-251_251_251_251_251_251L)).isEqualTo("Minus two hundred and fifty one quadrillion two hundred and fifty one trillion two hundred and fifty one billion two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
    assertThat(this.service.translate(-2_251_251_251_251_251_251L)).isEqualTo("Minus two quintillion two hundred and fifty one quadrillion two hundred and fifty one trillion two hundred and fifty one billion two hundred and fifty one million two hundred and fifty one thousand two hundred and fifty one");
  }


  @Test(expected = IllegalArgumentException.class)
  public void translateLowerThan1000_0() {
    this.service.translateLowerThan1000(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void translateLowerThan1000_negative() {
    this.service.translateLowerThan1000(-12);
  }

  @Test
  public void translateLowerThan1000_various() {
    assertThat(this.service.translateLowerThan1000(7)).containsExactly("seven");
    assertThat(this.service.translateLowerThan1000(21)).containsExactly("twenty", "one");
    assertThat(this.service.translateLowerThan1000(199)).containsExactly("one", "hundred", "and", "ninety", "nine");
  }
}
