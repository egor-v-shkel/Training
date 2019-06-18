package by.vision.training.LambdaAndStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {

    public static void main(String[] args) {
        final List<Integer> ints = new ArrayList<>();
        IntStream.range(0, 1000000)
                .parallel()
                .forEach(i -> ints.add(i));
        System.out.println(ints.size());
    }

}
