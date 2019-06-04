package by.vision.training.Schildt.LambdaExpressions;

@FunctionalInterface
interface BetweenInterface{

    Boolean checkRange(int x);

}

public class BetweenTenTwentyCheck {

    public static void main(String[] args) {
        BetweenInterface result = x -> (x >=10 && x<=20);
        System.out.println(result.checkRange(12));
        System.out.println(result.checkRange(22));
    }

}
