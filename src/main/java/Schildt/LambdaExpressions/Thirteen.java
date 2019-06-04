package Schildt.LambdaExpressions;

@FunctionalInterface
interface DivideThirteen {
    boolean divide(int i);
}

public class Thirteen {

    public static void main(String[] args) {

        DivideThirteen lambdaLink = i -> i%13 == 0;

        System.out.println(lambdaLink.divide(26));
        System.out.println(lambdaLink.divide(666));

    }

}
