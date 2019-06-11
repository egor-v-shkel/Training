package by.vision.training.LambdaAndStreams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeProvider {

    static Random random = new Random();
    static List<String[]> employeeData;
    static List<String> departments = Arrays.asList("IT", "Sales", "Super heroes");


    public EmployeeProvider() {
        try {
            fillEmployees();
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

    private void fillEmployees() throws URISyntaxException, IOException {

        Path path = Paths.get(getClass()
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

    public String getRandomName() {
        String[] randomEmployee = getRandom(employeeData);
        return randomEmployee[0];
    }

    public String getRandomLastName() {
        String[] randomEmployee = getRandom(employeeData);
        return randomEmployee[1];
    }

    public String getRandomDepartment() {
        return getRandom(departments);
    }

}
