package CodeWars;

public class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        int maxLgthStr = 0, index = 0;
        String str = "";
        for (int i = 0; i < strarr.length+1-k; i++){
            int tempSumm = 0;
            for (int j = 0; j < k; j++){
                tempSumm += strarr[i+j].length();
            }
            if (tempSumm > maxLgthStr) {
                maxLgthStr = tempSumm;
                index = i;
            }
            System.out.println("Temp summ = "+tempSumm+" at iteration - "+i);
        }
        for (int x = index; x < index+k; x++){
            str += strarr[x];
        }
        return str;
    }
}