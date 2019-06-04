package Schildt.LambdaExpressions;

interface NumericTest{
    boolean test (int x, int y);
}

public class LambdaDemo2 {
    public static void main(String args[]) {
        NumericTest lb = (int x, int y) -> x % y == 0;
        System.out.println(lb.test(1, 1));
    }
}
