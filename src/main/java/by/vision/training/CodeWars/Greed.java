package by.vision.training.CodeWars;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Greed {
    public static int greedy(int[] dice) {

        Map<Integer, Long> collect = Arrays.stream(dice)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int sum = 0;

        for (Map.Entry<Integer, Long> entry :
                collect.entrySet()) {
            while (entry.getValue() > 0) {
                Long val = entry.getValue();
                Integer key = entry.getKey();
                int multi = 1;
                if (key == 1) multi = 10;
                if (val > 2) {
                    sum += key * multi * 100;
                    entry.setValue(val - 3);
                    continue;
                }
                if (key == 1 || key == 5) {
                    sum += key * multi * 10;
                    entry.setValue(val - 1);
                    continue;
                }
                entry.setValue(val - 1);
            }
        }

        return sum;

    }
}
