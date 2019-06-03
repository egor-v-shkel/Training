package Schildt.LambdaExpressions;

import Interfaces.MyValueI;

public class MyValue implements MyValueI {
    public static void main(String args[]) {

        MyValueI myVal = () -> 98.6;

        System.out.println(myVal.getValue());

        MyValue mv = new MyValue();

    }

    @Override
    public double getValue() {
        return 0;
    }
}
