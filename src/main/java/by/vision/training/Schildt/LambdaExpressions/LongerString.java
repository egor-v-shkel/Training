package by.vision.training.Schildt.LambdaExpressions;

@FunctionalInterface
interface Compare {

    String compare(String s1, String s2);

}

public class LongerString {

    public static void main(String[] args) {

        Compare linkLambda = (s1, s2) -> s1.length() > s2.length() ? s1:s2;

        System.out.println(linkLambda.compare("1234", "5678"));

    }
}
