public class DigPow {

    public static long digPow(int n, int p) {
        String nums = ""+n;
        int summ = 0;
        for (int i = 0; i < nums.length(); i++){
            int digit = Character.getNumericValue(nums.charAt(i));
            summ += Math.pow(digit, p+i);
            System.out.println(digit+" pow "+(p+i)+" = "+Math.pow(digit, p+i));
        }
        System.out.println("Summ = "+summ);
        System.out.println("!!!"+n+" pow "+p+" = "+Math.pow(n, p));
        if (summ == Math.pow(n, p)) return p;
        else return -1;
    }

}
