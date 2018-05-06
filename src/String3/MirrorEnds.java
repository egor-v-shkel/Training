package String3;

public class MirrorEnds {
    public static String mirrorEnds(String str){
        int strL = str.length();
        int index = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) != str.charAt(strL-1-i)) break;
            index++;
        }
        return str.substring(0, index);
    }
}
