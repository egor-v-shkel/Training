package Array2;

public class Either24 {
    public static boolean either24(int[] nums) {
        boolean nextTwo = false;
        boolean nextFour = false;
        for (int i =0; i<nums.length-1; i++){
            if (nums[i] == 2 && nums[i+1] == 2) nextTwo = true;
            if (nums[i] == 4 && nums[i+1] == 4) nextFour = true;
            //System.out.println("iteration "+i+": nextTwo - "+nextTwo+" nextFour - "+nextFour);
        }
        return (nextTwo ^ nextFour);
    }
}
