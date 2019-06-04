package by.vision.training.CodingBat.String3;

public class SumNumbers {
    public static int sumNumbers(String str){
        int summ = 0;
        String[] strArr = str.split("\\D+");
        for (String s: strArr){
            if (!s.equals("")) summ += Integer.parseInt(s);
        }
        return summ;
    }
}
