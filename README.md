# Translate numbers to text: number-translator

Thank you for using number-translator. This is a simple java library to convert a long number into fully written out text. The library is meant for British English or Canadian English.

## Requirements
- The library requires JDK 1.8 or higher.
- To build the software, Apache Maven 3 is required.

## Features

#### British English
The library is meant for British English or Canadian English, which means that the word "and" is added to the result.
Example:
```
2005 -> Two thousand and five
```
#### Capitalization
By default, the first character is capitalized as per the acceptance criteria. There is also a service method available that allows you to disable this.
```
NumberTranslationService service = new NumberTranslationServiceImpl();
service .translate(123L);  // Capitalizes by default.
service .translate(123L, false); // Does not capitalize.
```
#### Jacoco
Jacoco was added to check for test coverage. When you run `mvn test`, a report is added to /target/site/jacoco/index.html.

## Using the application

#### Interactive
You can try an interactive REPL by running `Main.java`.

#### Use as library
If you want to use this service as part of your own java project, then upload the jar to your private repository, by adding your repository to the pom and run `mvn deploy`. You can then add it to the pom of your project:
```
<dependency>
	<groupId>com.dekkerr</groupId>
	<artifactId>number-translator</artifactId>
	<version>0.0.1</version>
</dependency>
```
The classes of interest are the interface `NumberTranslationService` and the implementation `NumberTranslationServiceImpl`.
