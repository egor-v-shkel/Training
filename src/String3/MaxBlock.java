package String3;

public class MaxBlock {
    public static int maxBlock(String str){
        //char tCh = str.charAt(0);
        int temp = 1;
        int count = 0;
        for (int i = 0; i < str.length()-1; i++){
            if (str.charAt(i) == str.charAt(i+1)) temp++;
            else {
                if (temp > count) count = temp;
                temp =1;
            }
            System.out.println("char - "+str.charAt(i)+". temp value - "+temp+". count value - "+count);
        }
        return count;
    }
}
