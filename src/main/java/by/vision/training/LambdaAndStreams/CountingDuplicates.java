package by.vision.training.LambdaAndStreams;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        Integer count = 0;

        Map<Integer, Long> collect = text.chars().boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (Map.Entry e :
                collect.entrySet()) {
            if ((long) e.getValue() > 1) count++;
        }


        return count;
    }
}
