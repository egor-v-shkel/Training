package CodeWars;

import java.util.Arrays;

public class SuperMarketQueue {
    public static void main(String args[]) {
        System.out.println(Solution.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }
}

class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] till = new int[n];
        for(int i:customers){
            int minInd = 0;
            int temp = till[0];
            for(int j = 0; j < till.length; j++){
                if (till[j] < temp){
                    temp = till[j];
                    minInd = j;
                }
            }
            till[minInd] += i;
        }
        int queueTime = 0;
        for (int k: till){
            if (queueTime < k) queueTime = k;
        }
        return queueTime;
    }

}

/*class Solution {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int[] result = new int[n];
        for(int i = 0; i < customers.length; i++){
            result[0] += customers[i];
            Arrays.sort(result);
        }
        return result[n-1];
    }

}*/
