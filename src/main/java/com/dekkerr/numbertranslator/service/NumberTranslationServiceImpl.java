package com.dekkerr.numbertranslator.service;

import com.dekkerr.numbertranslator.util.VisibleForTesting;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

import static com.dekkerr.numbertranslator.util.StringUtilities.capitalizeFirstCharacter;
import static com.dekkerr.numbertranslator.util.StringUtilities.concat;

@Singleton
public class NumberTranslationServiceImpl implements NumberTranslationService {

  private static final String ZERO = "Zero";

  private static final String SPACE_SEPARATOR = " ";

  private static final String AND = "and";

  private static final int HUNDRED_INT = 100;

  private static final String HUNDRED_STRING = "hundred";

  private static final String MIN_VALUE = "minus nine quintillion two hundred and twenty three quadrillion three hundred and seventy two trillion thirty six billion eight hundred and fifty four million seven hundred and seventy five thousand eight hundred and eight";

  @Override
  public String translate(long value) {
    return translate(value, true);
  }

  @Override
  public String translate(long value, boolean capitalizeFirstCharacter) {

    // Check the base case;
    if (value == 0) {
      return ZERO;
    } else if (value == Long.MIN_VALUE && capitalizeFirstCharacter) {
      return capitalizeFirstCharacter(MIN_VALUE);
    } else if (value == Long.MIN_VALUE) {
      return MIN_VALUE;
    }

    List<String> numberParts = new ArrayList<>();
    boolean negative = value < 0;

    // We make the value positive if it is negative and prepend MINUS_SIGN to the result.
    if (negative) {
      value *= -1;
    }

    // We need to make sure we only add " and " before the last part of the string.
    boolean andAdded = false;

    // We iterate over PowersOfTen from high to low. We subtract the value
    // from the input param, while adding words to numberParts.
    for (PowersOfTen powerValue : PowersOfTen.values()) {
      if (value >= powerValue.getLongValue()) {
        long numFits = value / powerValue.getLongValue();
        // We keep the temporary elements in a separate StringBuilder to help us place the "and" in the right place.
        StringBuilder part = new StringBuilder();
        if (numFits > 0) {
          for (String numStr : translateLowerThan1000(numFits)) {
            part.append(numStr);
            part.append(SPACE_SEPARATOR);
          }
        }
        part.append(powerValue.toString());
        numberParts.add(part.toString());
        value -= numFits * powerValue.getLongValue();
      }
    }

    // The remainder will be values between 1 and 1000. We add these to numberParts.
    if (value > 0) {
      List<String> rest = translateLowerThan1000(value);
      andAdded = rest.contains(AND);
      numberParts.add(concat(rest, false, false));
    }

    // We concatenate the list of values, while adding the word "and" in the right place.
    // We also capitalize the first character.
    return capitalizeFirstCharacter(concat(numberParts, !andAdded, negative));
  }

  /**
   * Broke this off into a separate method as this is reused both as a prefix and a suffix when dealing with large
   * numbers.
   *
   * @param value the value between between [1, ..., 999].
   * @return The String value corresponding to the value.
   */
  @VisibleForTesting
  List<String> translateLowerThan1000(long value) {
    if (value < 1 || value > 999) {
      throw new IllegalArgumentException("This method should be used for values between [-999, ..., 999]");
    }

    List<String> numberParts = new ArrayList<>();

    // Subtract hundreds and add String parts.
    if (value >= HUNDRED_INT) {
      int timesHundred = (int) value / HUNDRED_INT;
      numberParts.addAll(translateLowerThan1000(timesHundred));
      numberParts.add(HUNDRED_STRING);
      value -= timesHundred * HUNDRED_INT;
      if (value > 0) {
        numberParts.add(AND);
      }
    }

    // Subtract tens and add String parts.
    if (value >= 20) {
      MultiplesOfTen multipleOfTen = MultiplesOfTen.ofIntValue((int) value / 10 * 10);
      numberParts.add(multipleOfTen.getStringValue());
      value -= multipleOfTen.getIntValue();
    }

    // The remainder should be lower than 20. We turn this value into a String.
    if (value > 0) {
      numberParts.add(NumbersBelowTwenty.ofIntValue((int) value).getStringValue());
    }

    return numberParts;
  }
}
