package by.vision.training.LambdaAndStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        fillList();
    }

    public static void fillList(){
        EmployeeProvider employeeProvider = new EmployeeProvider();

        Stream.generate(() -> new Employee(employeeProvider.getRandomName(),
                employeeProvider.getRandomLastName(),
                employeeProvider.getRandomDepartment(),
                EmployeeProvider.random.nextInt(10000)))
                .limit(100).forEach(System.out::println);
    }

}
