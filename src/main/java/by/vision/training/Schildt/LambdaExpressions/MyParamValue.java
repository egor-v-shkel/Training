package by.vision.training.Schildt.LambdaExpressions;

import by.vision.training.Interfaces.MyParamValueI;

public class MyParamValue implements MyParamValueI {
    public static void main(String args[]) {

        MyParamValueI myPval = (double n) -> 1.0 / n;
        System.out.println(myPval.getValue(98.1));

    }

    @Override
    public double getValue(double v) {
        return 0;
    }
}
