# Imapact.com Take Home Assignment

The following code repository contains the solution for the Imapact.com Take Home Assignment. 
The project was completed using the gradle build system and Java 21.

## Requirements

- Java 21.0
- Gradle 4.4

## Running the project

Gradle is used to build and run the project. Gradle also _should_ take care of downloading all dependencies.
The project can be built using the gradle build command: 

On unix/Macos systems:

```
./gradlew clean     # cleans existing build artifacts
./gradlew build     # builds the project
./gradlew test      # runs the unit tests
./gradlew run       # runs the main method
```

On windows systems:

```
gradlew.bat clean   # cleans existing build artifacts
gradlew.bat build   # builds the project
gradlew.bat test    # runs the unit tests
gradlew.bat run     # runs the main method
```

## Unit Tests

The project includes comprehensive unit tests using JUnit 5 to verify the functionality of the NumberRangeSummerizer
implementation. The test cases cover:

- Empty input validation
- Single number input
- Sequential number ranges
- Non-sequential numbers with gaps
- Invalid input handling
- Input with duplicate numbers
- Input with different delimiter formats ("," vs ", ")

All test cases are located in the `src/test/java` directory and can be run using the gradle test command:

## About the Author

Hi, my name is Joshua Britz and I am currently a student at the University of Cape Town, pursuing a 
Bachelor of Science Honours in Computer Science. I am a passionate software developer and enjoy 
learning a variety of new technologies and languages. I currently hold a Bachelor of Science majoring in Computer 
Science, Mathematics and Mathematical statistics from the University of Cape Town.

Thank you for considering my application. Looking forward to hearing from you.

Joshua Britz - joshua.c.britz@gmail.com

https://www.linkedin.com/in/joshua-c-britz/