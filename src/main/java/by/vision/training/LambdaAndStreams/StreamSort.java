package by.vision.training.LambdaAndStreams;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSort {

    static List<Employee> randomEmployeesList = EmployeeProvider.getRandomEmployeesList(1_000);

    public static void main(String[] args) {

        Stream<Employee> stream = randomEmployeesList.stream()
                .sorted(Comparator.comparing(Employee::getSalary));
        testAndPrint(stream, "salary");

        int minSalary = 5_000;
        Stream<Employee> stream1 = randomEmployeesList.stream()
                .filter(x -> x.getSalary() > minSalary)
                //filter by unique object field
                .filter(distinctByKey(Employee::getFirstName))
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .reversed()
                        .thenComparing(Employee::getFirstName));
        testAndPrint(stream1, String.format("salary > %d, Department, then by First Name", minSalary));

        /*randomEmployeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors
                        .mapping(Employee::getFirstName, Collectors.
                                collectingAndThen(Collectors.toCollection(ArrayList::new), x -> x.sort(Comparator.naturalOrder())))))
                .forEach((k, v) -> {

                    System.out.println(k+":"+v)});*/

        String[] split = "String".split("");
        Arrays.asList(split).stream()
                .map(c -> (c+"another concurrent string").split(""))
                .flatMap(Stream::of)
                .sorted()
                .distinct()
                .forEach(System.out::println);

    }

    private static <T> void testAndPrint(Stream<T> stream, String message) {
        System.out.println("Sorting by "+message);
        long startTime = System.currentTimeMillis();
        stream.forEach(System.out::println);
        System.out.println("\nMethod take's " + (System.currentTimeMillis() - startTime) + " mils to complete");
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

}
