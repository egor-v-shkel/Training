public class RegExTry {
    public static void main(String args[]) {
        int count  = 0;
        String splitPattern = "\\W";
        String pattern = "\\w+[YZyz]";
        String str = "day2fyyyz";
        String[] strArr= str.split(splitPattern);
        for(String w: strArr) {
            if (w.matches(pattern)) count++;
        }
        System.out.println();
        System.out.println(count);
    }
}
