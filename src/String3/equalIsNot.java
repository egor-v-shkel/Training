package String3;

public class equalIsNot {
    public static void main(String args[]) {
        String str = "This is notnot";
        String[] arrOfIsStr = str.split(".*?is.*?");
        System.out.println(arrOfIsStr.length);
    }
}
