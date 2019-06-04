package CodeWars;

import java.util.Arrays;

public class NextBiggerNumber {
    public static long nextBiggerNumber(long n) {
        String str = ""+n;
        char[] arr = str.toCharArray();
        int arrL = arr.length;
        if (arrL <= 1) return -1;
        //char currBigNum = arr[arrL-1];
        int smallNumIndex = arrL-1;
        int j = 0;
        for (int i = arrL-2; i == 0; i--) {

            System.out.println(arr[i]);

            if (arr[i] >= arr[i -1]){

                //currBigNum = arr[i];

                if (arr[i] < arr[smallNumIndex]) smallNumIndex = i;

                if (i == 0) return -1;

                continue;

            } else {
                char temp = arr[i];
                arr[i] = arr[smallNumIndex];
                arr[smallNumIndex] = temp;
                j = i;
                break;
            }
        }

        Arrays.sort(arr, j+1, arrL);
        str = "";
        for (char c: arr){
            str += c;
        }

        return Integer.parseInt(str);

    }
}
