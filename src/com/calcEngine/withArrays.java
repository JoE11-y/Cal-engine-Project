package com.calcEngine;
        // Third mode

public class withArrays {
    public static void main(String[] args) {

        // This example contains implementation of For Loop, Arrays and For-each Loop

        double[] leftVals = {100.0d, 25.0d, 225.0d, 14.0d};
        // another way of declaring an array
        double[] rightVals;
        rightVals = new double[]{50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];
        //

        // the arrays used in the example are all known as parallel arrays, i.e. elements in each array with corresponding indexes work are meant to be used together

        // i.e. all first elements work together

        //

        for(int i = 0; i < opCodes.length; i++) {
            switch (opCodes[i]) {
                case 'a':
                    results[i] = leftVals[i] + rightVals[i];
                    break;
                case 's':
                    results[i] = leftVals[i] - rightVals[i];
                    break;
                case 'm':
                    results[i] = leftVals[i] * rightVals[i];
                    break;
                case 'd':
                    results[i] = rightVals[i] != 0 ? leftVals[i] / rightVals[i] : 0.0d; //this is a conditional assignment
                    break;
                default:
                    System.out.println("Invalid opcode: " + opCodes[i]);
                    results[i] = 0.0d;
                    break;
            }
        }

        for(double currentResult : results)
            System.out.println(currentResult);
    }
}
