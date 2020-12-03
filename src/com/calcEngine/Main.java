package com.calcEngine;
        // First mode
        //Building a system that will be able to perform a variety of different mathematical operations
public class Main {
    public static void main(String[] args) {

        //Example contains implementation of If and else if statements
        double value1 = 100.0d;
        double value2 = 0.0d;
        double result = 0.0d;
        char opCode = 'd';
        // a to indicate addition and s to indicate subtraction

        if(opCode == 'a')
            result = value1 + value2;
        else if(opCode == 's')
            result = value1 - value2;
        else if (opCode == 'm')
            result = value1 * value2;
        else if (opCode == 'd') {
            if (value2 != 0)
                result = value1 / value2;
        }
        else {
            System.out.println("Invalid opcode: " + opCode);
            result = 0.0d;
        }
            System.out.println(result);
    }

}
