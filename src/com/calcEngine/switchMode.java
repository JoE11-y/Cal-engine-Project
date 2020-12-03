package com.calcEngine;
    // second mode
public class switchMode {

    public static void main(String[] args) {

        // This example shows implementation of switches

        double value1 = 100.0d;
        double value2 = 0.0d;
        double result = 0.0d;
        char opCode = 'f';

        switch(opCode) {
            case 'a':
                result = value1 + value2;
                break;
            case 's':
                result = value1 - value2;
                break;
            case 'm':
                result = value1 * value2;
                break;
            case 'd':
                result = value2 != 0 ? value1 / value2 : 0.0d; //this is a conditional assignment
                break;
            default:
                System.out.println("Invalid opcode: " + opCode);
                result = 0.0d;
                break;
        }
        System.out.println(result);
    }

}
