package com.calcEngine;
// tenth mode
import java.time.LocalDate;
import java.util.Scanner;

public class withPrimitiveWrapperClass {

    // Note This program in the interactive mode can only take numbers within range zero to nine
    // to enter into dateMath mode, you select which mode wanted simpleOperation for normal operation and dateMath for date math
    // format is "yyyy-mm-dd plus/minus number days/weeks/months/year"
    // example "2020-05-22 plus seven months"

    // Added Functionality is that the program not only receives numbers as string, but also as integers

    public static void main(String[] args) {
        // ways to test this programs
        // one: by using the method in the fifth mode or
        // Intellij can help with passing command line args, this is done by changing the programs configurations in the
        // in the run section, and typing the args into the Program arguments option. This acts just as if the program
        // was ran with command line arguments, after compiling, type the operation to be carried out in the terminal
        double[] leftVals = {100.0d, 25.0d, 225.0d, 14.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        if (args.length == 0) {
            for (int i = 0; i < opCodes.length; i++) {
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);
            }
            for (double currentResult : results)
                System.out.println(currentResult);
        }else if(args.length == 1 && args[0].equals("interactive"))
            executeInteractively();
        else if(args.length == 3)
            handleCommandLine(args);
            // this method process through the command line argument
            // so the args array is passed into it as a parameter.
        else
            System.out.println("Please provide an operation code and 2 numeric values");
    }

    static void executeInteractively(){
        System.out.println("Enter an operation: simpleOperation/dateMath");
        // This function is for interacting with the user

        // to get information from the user, System.in can be used but this will require a lot of housekeeping so a

        // datatype called Scanner will be used to do this housekeeping

        // this Scanner datatype is imported from the java.util directory

        Scanner scanner = new Scanner(System.in);

        // the parameter passed in is system.in which means that this instance of scanner will take care of the details

        // of getting the input from the user, all that is needed is to ask the scanner for the inputs and that is done by

        String userInputOperation = scanner.nextLine();

        // this reads all the input from the user until they enter the enter key, it then returns the input as a string

        if(userInputOperation.equals("simpleOperation"))
            simpleOperation();
        else if(userInputOperation.equals("dateMath")){
            dateMath();
        }else {
            System.out.println("Please select any of the above operations");
        }
    }

    static void simpleOperation(){
        System.out.println("Enter an operation and two numbers");

        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        String[] parts = userInput.split(" "); // splits the input into spaces, it returns the string as a string array

        performOperation(parts);
    }

    static void dateMath(){
        System.out.println("Enter date(YYYY-MM-DD) and operation");

        Scanner scanner = new Scanner(System.in);

        String userInput = scanner.nextLine();

        String[] parts = userInput.split(" "); // splits the input into spaces, it returns the string as a string array

        handleDate(parts);
    }

    private static void performOperation(String[] parts) {
        // translates the string parts into data_types the application already understand
        char opCode = opCodeFromString(parts[0]);
        double leftVal = valueFromWord(parts[1]);
        double rightVal = valueFromWord(parts[3]);
        double result = execute(opCode, leftVal, rightVal);
        displayResult(opCode, leftVal, rightVal, result);
    }

    private static void handleDate(String[] parts) {
        LocalDate startDate = LocalDate.parse(parts[0]);
        LocalDate newDate;
        long val = (long) valueFromWord(parts[2]);
        String dateUnit = parts[3];
        if(parts[1].equals("plus"))
            newDate = dateAdd(dateUnit, startDate, val);
        else {
            newDate = dateMinus(dateUnit, startDate, val);
        }
        String output = String.format("%s %s %d %s is %s", startDate, parts[1], val, parts[3], newDate);
        System.out.println(output);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        // this function uses the string format method to display the work to the user
        char symbol = symbolFromOpcode(opCode);

        String output = String.format("%.3f %c %.3f = %.3f", leftVal, symbol, rightVal, result);

        System.out.println(output);
    }


    private static char symbolFromOpcode(char opCode) {
        // this function is in charge of getting the symbol for the new output message
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/'};
        char symbol = ' ';
        for(int index = 0; index < opCodes.length; index++){
            if(opCode == opCodes[index]){
                symbol = symbols[index];
                break;
            }
        }
        return symbol;
    }

    private static void handleCommandLine(String[] args) {
        // strings are considered sequence of characters so for the opCode it's the first character of string
        char opCode = args[0].charAt(0); // to extract the first character of the string opCode
        double leftVal = Double.parseDouble(args[1]); //converts string to double
        double rightVal = Double.parseDouble(args[2]); //converts string to double
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);

    }

    static double execute(char opCode, double leftVal, double rightVal ) {
        double result;
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                result = rightVal != 0 ? leftVal/ rightVal : 0.0d; //this is a conditional assignment
                break;
            default:
                System.out.println("Invalid opcode: " + opCode);
                result = 0.0d;
                System.out.println("Please provide an operation code and 2 numeric values");
                break;
        }
        return result;
    }

    static char opCodeFromString(String operationName){
        // this function is for extracting the opCode from the input
        char opCode = operationName.charAt(0);
        return opCode;
    }

    static double valueFromWord(String word){
        // this function is for extracting the value of the words from the input
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        double value = -1d; // this makes the value start out with something that's not valid
        for(int index = 0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])){
                value = index;
                break;
            }
        }
        if(value == -1) // this checks to see if the word could not be gotten from the above for loop, if not, value will still be set as -1
            value = Double.parseDouble(word); //converts string to doubleSS
        // now the valueFromWord can handle both integer(any number) and string(zero-nine)

        return value;
    }
    static LocalDate dateAdd(String dateUnit, LocalDate startDate, long value ) {
        LocalDate newDate;
        switch (dateUnit) {
            case "days":
                newDate = startDate.plusDays(value);
                break;
            case "weeks":
                newDate = startDate.plusWeeks(value);
                break;
            case "months":
                newDate = startDate.plusMonths(value);
                break;
            case "years":
                newDate = startDate.plusYears(value);
                break;
            default:
                System.out.println("Invalid date: " + startDate);
                newDate = LocalDate.parse("0000-00-00");
                System.out.println("Please provide an operation and two values");
                break;
        }
        return newDate;
    }
    static LocalDate dateMinus(String dateUnit, LocalDate startDate, long value ) {
        LocalDate newDate;
        switch (dateUnit) {
            case "days":
                newDate = startDate.minusDays(value);
                break;
            case "weeks":
                newDate = startDate.minusWeeks(value);
                break;
            case "months":
                newDate = startDate.minusMonths(value);
                break;
            case "years":
                newDate = startDate.minusYears(value);
                break;
            default:
                System.out.println("Invalid date: " + startDate);
                newDate = LocalDate.parse("0000-00-00");
                System.out.println("Please provide an operation and two values");
                break;
        }
        return newDate;
    }

}
