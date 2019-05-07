package com.dekkerr.numbertranslator.service;

import org.junit.Test;

import static com.dekkerr.numbertranslator.service.MultiplesOfTen.EIGHTY;
import static com.dekkerr.numbertranslator.service.MultiplesOfTen.FIFTY;
import static com.dekkerr.numbertranslator.service.MultiplesOfTen.FORTY;
import static com.dekkerr.numbertranslator.service.MultiplesOfTen.NINETY;
import static com.dekkerr.numbertranslator.service.MultiplesOfTen.SEVENTY;
import static com.dekkerr.numbertranslator.service.MultiplesOfTen.SIXTY;
import static com.dekkerr.numbertranslator.service.MultiplesOfTen.THIRTY;
import static com.dekkerr.numbertranslator.service.MultiplesOfTen.TWENTY;
import static org.assertj.core.api.Assertions.assertThat;

public class MultiplesOfTenTest {

  @Test(expected = IllegalArgumentException.class)
  public void testForInteger_ten() {
    MultiplesOfTen.ofIntValue(10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testForInteger_bad_val() {
    MultiplesOfTen.ofIntValue(42);
  }

  @Test
  public void testForInteger_twenty() {
    assertThat(MultiplesOfTen.ofIntValue(20)).isEqualTo(TWENTY);
  }

  @Test
  public void testForInteger_thirty() {
    assertThat(MultiplesOfTen.ofIntValue(30)).isEqualTo(THIRTY);
  }

  @Test
  public void testForInteger_fourty() {
    assertThat(MultiplesOfTen.ofIntValue(40)).isEqualTo(FORTY);
  }

  @Test
  public void testForInteger_fifty() {
    assertThat(MultiplesOfTen.ofIntValue(50)).isEqualTo(FIFTY);
  }

  @Test
  public void testForInteger_sixty() {
    assertThat(MultiplesOfTen.ofIntValue(60)).isEqualTo(SIXTY);
  }

  @Test
  public void testForInteger_seventy() {
    assertThat(MultiplesOfTen.ofIntValue(70)).isEqualTo(SEVENTY);
  }

  @Test
  public void testForInteger_eighty() {
    assertThat(MultiplesOfTen.ofIntValue(80)).isEqualTo(EIGHTY);
  }

  @Test
  public void testForInteger_ninety() {
    assertThat(MultiplesOfTen.ofIntValue(90)).isEqualTo(NINETY);
  }
}
