package com.dekkerr.numbertranslator.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.Optional;

@Getter
@FieldDefaults(makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
enum NumbersBelowTwenty {

  ONE(1, "one"),
  TWO(2, "two"),
  THREE(3, "three"),
  FOUR(4, "four"),
  FIVE(5, "five"),
  SIX(6, "six"),
  SEVEN(7, "seven"),
  EIGHT(8, "eight"),
  NINE(9, "nine"),
  TEN(10, "ten"),
  ELEVEN(11, "eleven"),
  TWELVE(12, "twelve"),
  THIRTEEN(13, "thirteen"),
  FOURTEEN(14, "fourteen"),
  FIFTEEM(15, "fifteen"),
  SIXTEEN(16, "sixteen"),
  SEVENTEEN(17, "seventeen"),
  EIGHTEEN(18, "eighteen"),
  NINETEEN(19, "nineteen");

  private int intValue;

  private String stringValue;

  static NumbersBelowTwenty ofIntValue(int intValue) {
    Optional<NumbersBelowTwenty> found = Arrays
        .stream(values())
        .filter(single -> single.intValue == intValue)
        .findFirst();
    if (!found.isPresent()) {
      throw new IllegalArgumentException("No value exists for input: " + intValue);
    }
    return found.get();
  }
}
