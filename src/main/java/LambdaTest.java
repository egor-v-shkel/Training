import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Sam", "Brown", 1000, 400));
        employeeList.add(new Employee("Dan", "Smith", 2000, 400));
        employeeList.add(new Employee("Pam", "Dickson", 1200, 450));
        employeeList.add(new Employee("Walter", "White", 9999, 9999));

        Predicate<Employee> white = x -> x.lastName.equals("White");
        Predicate<Employee> sam = x -> x.firstName.equals("Sam");
        List<Employee> sorted = getEmployee(employeeList, white.or(sam));
        sorted.forEach(System.out::println);

        getEmployee(employeeList, white.or(sam).negate())
                .forEach(System.out::println);

        //increase salary only for employee with high sales
        int increment = 100;
        BiConsumer<Employee, Integer> increase = (x, y) -> x.setSalary(x.getSalary() + y);
        increaseSalary(employeeList, increment, increase);
        employeeList.forEach(System.out::println);

    }

    private static <T, R> void increaseSalary(List<T> list, R increasement, BiConsumer<T, R> biccoms) {

        for (T e :
                list) {
            biccoms.accept(e, increasement);
        }

    }

    private static <T> List<T> getEmployee(List<T> employees, Predicate<T> predicate) {
        List<T> list = new ArrayList<>();
        for (T e :
                employees) {
            if (predicate.test(e)) list.add(e);
        }
        return list;
    }

    private static <T, R> List<T> modify(List<T> employees, Function<T,R> func) {
        List<T> list = new ArrayList<>();
        for (T e :
                employees) {
            func.apply(e);
        }
        return list;
    }
}

class Employee {
    String firstName;
    String lastName;
    int sale;
    int salary;

    public Employee(String firstName, String lastName, int sale, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sale = sale;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sale=" + sale +
                ", salary=" + salary +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}