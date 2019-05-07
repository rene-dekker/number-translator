package com.dekkerr.numbertranslator.service;

public interface NumberTranslationService {

  /**
   * Fully writes out a long value into a String.
   *
   * @param value                    Ex. 225
   * @param capitalizeFirstCharacter if true, the service will capitalize the first character.
   * @return "Two hundred and twenty five"
   */
  String translate(long value, boolean capitalizeFirstCharacter);

  /**
   * Fully writes out a long value into a String. By default the first character is capitalized as per requirements.
   *
   * @param value Ex. 225
   * @return "Two hundred and twenty five"
   */
  String translate(long value);
}
