package com.automation.utils;

public class Verification {

    public static int checkMultiply(int a, int b){
        return a * b;
    }

    public static float checkRoot(int a){
        return (float) Math.sqrt(a);
    }

    public static float checkDivide(int a, int b){
        if (b == 0){
            return 0;
        }
        return (float) a / b;
    }
}
