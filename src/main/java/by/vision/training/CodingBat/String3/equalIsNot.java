package by.vision.training.CodingBat.String3;

public class equalIsNot {
    public static void main(String[] args) {
        String str = "noisxxnotyynotxisi";
        String is = "is";
        String not = "not";
        int isNum = 0;
        int notNum = 0;
        for (int i = 0; i < str.length()-1; i++){
            if (str.substring(i, i+2).equals(is)) isNum++;
            if (i < str.length()-2 && str.substring(i, i+3).equals(not)) notNum++;
        }
        System.out.println(isNum == notNum);
    }
}
