public class noTriples {
    public static void main(String args[]){
        int nums[] = {1, 1, 1, 2, 2, 2, 1};
        for (int i = 0; i < nums.length - 2; i++){
            if (nums[i] == nums[i+1] && nums[i] == nums[i+2]){
                System.out.println("tripples!");
            }
        }
    }
}
