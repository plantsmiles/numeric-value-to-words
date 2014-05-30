numeric-value-to-words
======================

Program accepts numbers and converts them to their english word representation. (EX. 2523.04 to Two thousand five hundred twenty-three and 04/100 dollars)

Building the Application
------------------------

The application uses a gradle wrapper to build, run the tests, and package the application. On Unix machines run:

	./gradlew clean build
	
For windows machine use:

	gradle.bat clean build

Running the Application
-----------------------

After building the application with gradle run the following command passing space delimited numbers as arguments to the jar.  Example is as follows:

	java -jar build/libs/NumericValueToWords-1.0.jar 2046.06
	
This will produce the output:

    Converted Value: 2046.06 => two thousand forty-six 6/100 dollars
