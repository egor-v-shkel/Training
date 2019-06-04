package by.vision.training.Array2;

public class BigDiff {
    public static int bigDiff(int[] nums) {
        int numMin = nums[0];
        int numMax = nums[0];
        for (int i : nums){
            numMin = Math.min(numMin, i);
            numMax = Math.max(numMax, i);
            System.out.println("min - "+numMin+". max - "+numMax);
        }
        return numMax+numMin;
    }
}
