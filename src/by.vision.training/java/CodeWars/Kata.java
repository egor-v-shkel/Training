package CodeWars;

import java.util.Arrays;

public class Kata{
    public static int getLengthOfMissingArray(Object[][] arrayOfArrays){
        int arrOfArrLeng = arrayOfArrays.length;
        int[] arrOfInArrLeng = new int[arrOfArrLeng];

        if (arrayOfArrays == null || arrOfArrLeng == 0) return 0;

        for(int i = 0; i < arrOfArrLeng; i++){
            int arrLeng = arrayOfArrays[i].length;
            System.out.println("Length form int - "+arrLeng);
            System.out.println("Length without int - "+arrayOfArrays[i].length);
            if (arrayOfArrays[i] == null || arrLeng == 0) return 0;
            arrOfInArrLeng[i] = arrLeng;
        }

        Arrays.sort(arrOfInArrLeng);

        for(int j = 0; j < arrOfInArrLeng.length - 1; j++){
            if (arrOfInArrLeng[j+1] - arrOfInArrLeng[j] != 1) return arrOfInArrLeng[j]+1;
        }
        return 0;
    }
}
