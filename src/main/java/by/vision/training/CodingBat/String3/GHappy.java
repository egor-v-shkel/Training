package by.vision.training.CodingBat.String3;

public class GHappy {
    public static void method(String str){
        System.out.println(!str.matches(".*(^|[^g])[g]([^g]|$).*"));
    }
}
