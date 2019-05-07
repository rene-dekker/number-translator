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
enum MultiplesOfTen {

  TWENTY(20, "twenty"),
  THIRTY(30, "thirty"),
  FORTY(40, "forty"),
  FIFTY(50, "fifty"),
  SIXTY(60, "sixty"),
  SEVENTY(70, "seventy"),
  EIGHTY(80, "eighty"),
  NINETY(90, "ninety");

  private int intValue;

  private String stringValue;

  static MultiplesOfTen ofIntValue(int intValue) {
    Optional<MultiplesOfTen> found = Arrays
        .stream(values())
        .filter(single -> single.intValue == intValue)
        .findFirst();
    if (!found.isPresent()) {
      throw new IllegalArgumentException("No value exists for input: " + intValue);
    }
    return found.get();
  }
}
