package Schildt.LambdaExpressions;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.*;

public class CalculateExpression implements DiscriminantCalculationI {

    @Override
    public double calculate(double a, double b, double c) {
        return 0;
    }

    public static void main(String[] args) {
        DiscriminantCalculationI exp = (a, b, c) -> a*pow(b, c);
        System.out.println(exp.calculate(0.1, 0.2, 0.3));
    }
}
