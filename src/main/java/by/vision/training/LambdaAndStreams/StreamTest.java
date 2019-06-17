package by.vision.training.LambdaAndStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        //fillList();
        randomIntStream();
    }

    public static void fillList(){
        EmployeeProvider employeeProvider = new EmployeeProvider();

        Stream.generate(() -> new Employee(EmployeeProvider.getRandomName(),
                EmployeeProvider.getRandomLastName(),
                EmployeeProvider.getRandomDepartment(),
                EmployeeProvider.random.nextInt(10000)))
                .limit(100).forEach(System.out::println);
    }

    private static void randomIntStream(){

        Stream.generate(EmployeeProvider::getRandomEmployee).limit(6).forEach(System.out::println);

    }

}
