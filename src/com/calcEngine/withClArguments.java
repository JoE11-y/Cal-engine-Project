package com.calcEngine;
        // Fifth mode

public class withClArguments {

    public static void main(String[] args) {
        // in this format when no command-line arguments App will process through the arrays
        // so if the user passes in 3 command line arguments (opCode leftVal rightVal)
        // then app will perform calculation using the command-line arguments
        // this part of the prog was ran on the command line as intellij can perform explicit builds
        // to run this program go to the build option select build then go to the out\production\GADS directory and
        // run the ffg instruction "java com.calcEngine.withClArguments" then test out the program functions
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
        } else if(args.length == 3)
            handleCommandLine(args);
            // this method process through the command line argument
            // so the args array is passed into it as a parameter.
        else
            System.out.println("Please provide an operation code and 2 numeric values");
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
}
