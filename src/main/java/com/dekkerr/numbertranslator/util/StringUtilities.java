package com.dekkerr.numbertranslator.util;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class StringUtilities {

  private static final String SPACE_SEPARATOR = " ";

  private static final String AND = "and";

  private static final String MINUS_SIGN = "minus";

  /**
   * Capitalize the first character of a given String.
   *
   * @param string Ex. pancake
   * @return Ex, "Pancake"
   */
  public static String capitalizeFirstCharacter(String string) {

    if (string == null || string.length() == 0) {
      return string;
    }

    if (string.length() == 1) {
      return string.toUpperCase();
    }

    return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
  }

  /**
   * Concatenates a list of Strings into a single string. Adds "and" before the last number.
   *
   * @param numberParts          ["two hundred", "twenty five"]
   * @param addAndBeforeLastPart If this is specified, the word "and" will be added before the last part of the String.
   * @return Returns the concatenated String. Ex: "two hundred and twenty five"
   */
  public static String concat(List<String> numberParts,
                              boolean addAndBeforeLastPart,
                              boolean negativeValue) {
    if (numberParts == null) {
      return null;
    }

    int size = numberParts.size();

    if (size == 1 && !negativeValue) {
      return numberParts.get(0);
    }

    if (size == 1 && negativeValue) {
      return MINUS_SIGN + SPACE_SEPARATOR + numberParts.get(0);
    }

    StringBuilder result = new StringBuilder();

    if (negativeValue) {
      result.append(MINUS_SIGN);
      result.append(SPACE_SEPARATOR);
    }

    for (int i = 0; i < size; i++) {
      if (i != 0) {
        result.append(SPACE_SEPARATOR);
      }
      if (addAndBeforeLastPart && i == size - 1) {
        result.append(AND);
        result.append(SPACE_SEPARATOR);
      }
      result.append(numberParts.get(i));
    }
    return result.toString();
  }
}
