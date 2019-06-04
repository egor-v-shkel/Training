package Schildt.LambdaExpressions;

interface NumericFunc{
    int func(int x);
}

public class BlockLambdaExpression {
    public static void main(String args[]) {

        NumericFunc smallestF = (int n) -> {
            int result = 1;

            //Get absolute value of n;
            n = Math.abs(n);

            for(int i = 2; i <= n/i; i++){

                if(n%i == 0) {
                    result = i;
                    break;
                }

            }

            return result;
        };

        System.out.println("Min divider for 17 is "+smallestF.func(17));

    }
}
