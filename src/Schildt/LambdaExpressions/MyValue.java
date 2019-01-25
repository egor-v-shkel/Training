package Schildt.LambdaExpressions;

import Interfaces.MyValueI;

public abstract class MyValue implements MyValueI {
    public static void main(String args[]) {

        MyValueI myVal = () -> 98.6;

        System.out.println(myVal.getValue());

    }
}
