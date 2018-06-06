import java.util.Arrays;

public class Test {
    public static void main(String args[]) {

    }
}


class Kata1
{
    public static int getLengthOfMissingArray(Object[][] arrayOfArrays)
    {
        if (arrayOfArrays == null || arrayOfArrays.length == 0) return 0;

        int[] arrayOfSizes = new int[arrayOfArrays.length];

        for (int i = 0; i < arrayOfArrays.length; i++) {
            if(arrayOfArrays[i] == null ||arrayOfArrays[i].length == 0) return 0;

            arrayOfSizes[i] = arrayOfArrays[i].length;
        }

        Arrays.sort(arrayOfSizes);
        for (int i = 0; i < arrayOfSizes.length-1; i++) {
            if(arrayOfSizes[i+1] - arrayOfSizes[i] - 1 != 0) {
                return arrayOfSizes[i] + 1;
            }
        }

        return 0;
    }
}
