import java.util.Objects;
public class AltPairs {
    public static void main(String args[]){
        char y = 'y';
        char a = 'a';
        char k = 'k';
        String str = "yakChocolate";
        String finalString = "";
        for (int i = 0; i < str.length() - 2; i++){
            if (Objects.equals(str.charAt(i), y) && Objects.equals(str.charAt(i), a) && Objects.equals(str.charAt(i), k)){
                i += 2;
                continue;
            }
            finalString += str.charAt(i);
        }
        System.out.println(finalString);
        System.out.println("New text");
    }
}
