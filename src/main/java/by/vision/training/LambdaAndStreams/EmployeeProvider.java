package by.vision.training.LambdaAndStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EmployeeProvider {

    static Random random = new Random();

    static String[] names = {"Andy", "Tom", "Bob", "Alice", "Tobey", "Arnold", "Tony"};
    static String[] lastNames = {"Brown", "Trump", "Maguire", "Alice", "White", "Stark"};
    static String[] departments = {"IT", "Sales", "Super heroes"};

    public static <T> T getRandom(T[] array){
        List<T> list = new ArrayList<>(Arrays.asList(array));
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }

}
