package Array2;

public class Has22 {
    public static boolean has22(int[] nums) {
        for(int i = 0; i < nums.length-1; i++){
            if (nums[i] == 2 && nums[i] == nums[i+1]) return true;
        }
        return false;
    }

}
