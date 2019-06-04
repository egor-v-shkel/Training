package by.vision.training.Schildt.LambdaExpressions;

@FunctionalInterface
interface DiscriminantCalculationI{
    double calculate(double a, double b, double c);
}

public class DiscriminantCalculation {

    public static void main(String[] args) {

        DiscriminantCalculationI disc = (a, b, c) -> ((Math.pow(b, 2)) - (4 * a * c));

        System.out.println(disc.calculate(0.1, 1.0, 0.3));

    }

}
