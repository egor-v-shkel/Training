package Schildt.LambdaExpressions;

import java.util.Arrays;
import java.util.List;

public class ArrayPrint {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        arr.forEach(System.out::println);

    }

}
