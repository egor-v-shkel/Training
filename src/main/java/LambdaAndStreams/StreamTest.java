package LambdaAndStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        fillList();
    }

    public static void fillList(){
        Stream.generate(() -> {
            String[] names = EmployeeProvider.names;
            String[] lastNames = EmployeeProvider.lastNames;
            String[] departments = EmployeeProvider.departments;
            return new Employee(EmployeeProvider.getRandom(names),
                    EmployeeProvider.getRandom(lastNames),
                    EmployeeProvider.getRandom(departments),
                    EmployeeProvider.random.nextInt(10000));
        })
                .limit(100).forEach(System.out::println);
    }

}
