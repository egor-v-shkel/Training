package String3;

public class SumDigits {
    public static int sumDigits(String str) {
        int count = 0;
        for (int i=0; i < str.length(); i++){
            if (Character.isDigit(str.charAt(i)))
                count += Integer.parseInt(str.substring(i, i+1));
        }
        return count;
    }
}
