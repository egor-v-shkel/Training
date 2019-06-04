package CodingBat.String3;

public class MaxBlock {
    public static int maxBlock(String str){
        int temp = 1;
        int count = 0;
        for (int i = 0; i < str.length()-1; i++){
            if (str.charAt(i) == str.charAt(i+1)) temp++;
            else {
                if (temp > count) count = temp;
                temp =1;
            }
        }
        return Math.max(temp, count);
    }
}
