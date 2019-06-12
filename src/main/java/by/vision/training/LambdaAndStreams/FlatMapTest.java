package by.vision.training.LambdaAndStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlatMapTest {

    public static void main(String[] args) {
        List<Human> humans = Arrays.asList(
                new Human("sam", Arrays.asList("buddy", "lucy")),
                new Human("bob", Arrays.asList("frankie", "rosie")),
                new Human("marta", Arrays.asList("simba", "tilly")));

        List<String> petnames = humans.stream()
                .map(Human::getPets) //преобразовываем stream<human> в stream<list<pet>>
                .flatMap(pets -> pets.stream())//"разворачиваем" stream<list<pet>> в stream<pet>
                .collect(Collectors.toList());

        System.out.println(petnames); // output [buddy, lucy, frankie, rosie, simba, tilly]

/*
        IntStream.concat(
                IntStream.range(0, 100000000),
                IntStream.of(-1, -2))
                .sorted()
                .limit(3)
                .forEach(System.out::println);
*/

        IntStream.range(-3, 6).forEach(System.out::print);
        System.out.println();

        int product = IntStream.range(0, 10)
                .filter(x -> x++ % 4 == 0)
                .reduce((acc, x) -> acc * x)
                .getAsInt();

        System.out.println(product);
    }

}
