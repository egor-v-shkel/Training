import java.util.Objects;

public class Main {

    public static void main(String args[]) {
        String str = "asdasdasd";
        for (int i = 0; i < str.length() - 1; i++) {
            if (Objects.equals(str.charAt(i), 'x')) {
                if (Objects.equals(str.charAt(i + 1), 'x')) {
                    System.out.println("true");
                    break;
                }
            }
            }
        }
        }
          /*  if (Objects.equals(str.charAt(i), 'x') && Objects.equals(str.charAt(i + 1), 'x')){
                return true;*/