package com.calcEngine;
    // Sixth Mode

import java.util.Scanner;

public class withStringsMods {
    // this contains modifications and enhancement of the application with strings
    // Note This program in the interactive mode can only take numbers within range zero to nine
    // in the format (operation leftVal and rightVal)
    // Example (multiply seven and five)
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
        System.out.println("Enter an operation and two numbers");
        // This function is for interacting with the user

        // to get information from the user, System.in can be used but this will require a lot of housekeeping so a

        // datatype called Scanner will be used to do this housekeeping

        // this Scanner datatype is imported from the java.util directory
        Scanner scanner = new Scanner(System.in);

        // the parameter passed in is system.in which means that this instance of scanner will take care of the details

        // of getting the input from the user, all that is needed is to ask the scanner for the inputs and that is done by

        String userInput = scanner.nextLine();

        // this reads all the input from the user until they enter the enter key, it then returns the input as a string

        String[] parts = userInput.split(" "); // splits the input into spaces, it returns the string as a string array
        
        performOperation(parts);

    }

    private static void performOperation(String[] parts) {
        // translates the string parts into data_types the application already understands
        char opCode = opCodeFromString(parts[0]);
        double leftval = valueFromWord(parts[1]);
        double rightval = valueFromWord(parts[3]);
        double result = execute(opCode,leftval,rightval);
        System.out.println(result);
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
        double value = 0d;
        for(int index = 0; index < numberWords.length; index++){
            if(word.equals(numberWords[index])){
                value = index;
                break;
            }
        }
        return value;
    }


}
