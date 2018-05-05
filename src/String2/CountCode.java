/*package String2;

public class CountCode {
    public static void main(String args[]) {
        String a = "Hiabc";
        String b = "abc";
        endOther(a, b);
    }
}

    boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        int aLeng = a.length();
        int bLeng = b.length();
        (aLeng >= bLeng) ? return checkContainStr(a, b, aLeng, bLeng) : return checkContainStr(b, a, bLeng, aLeng);
    }

    void checkContainStr (String a, String b, int aLeng, int bLeng){
        for (int i = 0; i < (aLeng-bLeng); i++) {
            return (a.substring(0, bLeng).equals(b));
        }
    }
*/