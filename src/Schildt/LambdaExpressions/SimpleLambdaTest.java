package Schildt.LambdaExpressions;

import java.util.concurrent.Callable;

public class SimpleLambdaTest {

    public static void main(String[] args) throws Exception {

        Callable<Integer> callInt = () -> 666;

        System.out.println(callInt.call());
    }


}
