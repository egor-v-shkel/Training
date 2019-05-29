package CodeWars;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a positive integral number n, return a strictly increasing sequence (list/array/string depending on the language) of numbers, so that the sum of the squares is equal to n².
 *
 * If there are multiple solutions (and there will be), return the result with the largest possible values:
 *
 * Examples
 * decompose(11) must return [1,2,4,10]. Note that there are actually two ways to decompose 11², 11² = 121 = 1 + 4 + 16 + 100 = 1² + 2² + 4² + 10² but don't return [2,6,9], since 9 is smaller than 10.
 *
 * For decompose(50) don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.
 *
 * Note
 * Neither [n] nor [1,1,1,…,1] are valid solutions. If no valid solution exists, return nil, null, Nothing, None (depending on the language) or "[]" (C) ,{} (C++), [] (Swift, Go).
 *
 * The function "decompose" will take a positive integer n and return the decomposition of N = n² as:
 *
 * [x1 ... xk] or
 * "x1 ... xk" or
 * Just [x1 ... xk] or
 * Some [x1 ... xk] or
 * {x1 ... xk} or
 * "[x1,x2, ... ,xk]"
 * depending on the language (see "Sample tests")
 *
 * Hint
 * Very often xk will be n-1.
 */
public class Decompose {

    List<Integer> array;

    public String decompose(long n) {

        int start = 9;
        int end = 13;



        for (int i = end; i > start; i--) {
            int k = i-1;
            for (int j = 0; j < k; j++) {
                array = new ArrayList<>();
                array.add(k);
                func((int) (Math.pow(i, 2) - Math.pow(k, 2)));
                System.out.println(array);
                System.out.println();
                int sum = array.stream().mapToInt(Integer::intValue).sum();
                System.out.println("Summ: "+sum);
                System.out.println();
            }
            System.out.println("=================================================");
        }

        return  null;

    }

    private int func(int i) {
        double sqrt = Math.sqrt(i);
        int floor = (int) Math.floor(sqrt);
        array.add(floor);
        int i1 = (int)(i - Math.pow(floor, 2));
        if (i1 <= 2) return 0;
        func(i1);
        return 1;
    }
}
