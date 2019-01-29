package CodingBat.String3;

public class SameEnds {
    public static String sameEnd(String str){
        int strL = str.length();
        int index = 0;
        if (strL < 2) return "";
        for (int i = 0; i < str.length()/2+1; i++){
            String temp = str.substring(0, i);
            System.out.println(temp);
            if (str.endsWith(temp)) index = i;
        }
        return str.substring(0, index);
    }
}
