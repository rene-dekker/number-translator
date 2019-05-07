package com.dekkerr.numbertranslator.application;

import com.dekkerr.numbertranslator.service.NumberTranslationService;
import com.dekkerr.numbertranslator.service.NumberTranslationServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    NumberTranslationService numberTranslationService = new NumberTranslationServiceImpl();
    numberTranslationService.translate(123L);
    numberTranslationService.translate(123L, false);

    System.out.println("This is the number translator. We will prompt you for numeric values between\n" +
        "[-9,223,372,036,854,775,808, ..., 9,223,372,036,854,775,807] and print the\nfully written outversion " +
        "onto the screen. Decimal numbers are not supported. \n");

    Scanner scanner = new Scanner(System.in);
    while (true) {
      System.out.println("Choose a number: \n");
      String next = scanner.next().replaceAll(",", "");

      if (!NumberUtils.isCreatable(next) || StringUtils.containsAny(next, " ", "\t", "\n")) {
        System.out.println("The value must be numeric, please try again. \n");
        continue;
      }
      try {
        long numericValue = Long.parseLong(next);
        System.out.println(String.format("The result of %s is: %s\n", numericValue, numberTranslationService.translate(numericValue)));
      } catch (NumberFormatException e) {
        System.out.println("The value must be between [-9,223,372,036,854,775,808, ..., 9,223,372,036,854,775,807], " +
            "please try again. \n");
      }
    }
  }
}
