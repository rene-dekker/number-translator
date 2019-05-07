package com.dekkerr.numbertranslator.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(makeFinal = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
enum PowersOfTen {

  /**
   * Must be in descending order of greatness.
   */
  QUINTILLION(18, 1_000_000_000_000_000_000L), // Highest we need to cover min / max long value.
  QUADRILLION(15, 1_000_000_000_000_000L),
  TRILLION(12, 1_000_000_000_000L),
  BILLION(9, 1_000_000_000L),
  MILLION(6, 1_000_000L),
  THOUSAND(3, 1_000L);

  /**
   * The enum name represents 10^power.
   */
  private int logBase;

  private long longValue;

  @Override
  public String toString() {
    return super.toString().toLowerCase();
  }
}
