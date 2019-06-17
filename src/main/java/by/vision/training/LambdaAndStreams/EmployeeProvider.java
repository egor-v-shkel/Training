package by.vision.training.LambdaAndStreams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class EmployeeProvider {

    static Random random = new Random();
    static List<String[]> employeeData;


    public EmployeeProvider() {
        try {
            fillEmployees();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillEmployees() throws URISyntaxException, IOException {

        Path path = Paths.get(EmployeeProvider.class
                .getClassLoader()
                .getResource("by.vision.training/random_names.txt")
                .toURI());

        Stream<String> lines = Files.lines(path);
        employeeData = lines.map(x -> x.split(" ")).collect(Collectors.toCollection(ArrayList::new));
        lines.close();

    }

    private static <T> T getRandom(List<T> array) {
        int randomIndex = random.nextInt(array.size());
        return array.get(randomIndex);
    }

    public static String getRandomName() {
        String[] randomEmployee = getRandom(employeeData);
        return randomEmployee[0];
    }

    public static String getRandomLastName() {
        String[] randomEmployee = getRandom(employeeData);
        return randomEmployee[1];
    }

    public static Employee.Department getRandomDepartment() {
        List<Employee.Department> VALUES =
                Collections.unmodifiableList(Arrays.asList(Employee.Department.values()));
        int SIZE = VALUES.size();
            return VALUES.get(random.nextInt(SIZE));
    }

    public static Employee getRandomEmployee(){
        if (employeeData == null) {
            try {
                fillEmployees();
                System.out.println("employyes data was filled");
            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
            }
        }
        return new Employee(getRandomName(), getRandomLastName(), getRandomDepartment(), random.nextInt(10000));
    }

    public static List<Employee> getRandomEmployeesList(int size){

        List<Employee> employeeList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            employeeList.add(getRandomEmployee());
        }
        return employeeList;
    }

}
