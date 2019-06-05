package LambdaAndStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class LambdaTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(new Employee("Sam", "Brown", 1000, 400));
//        employeeList.add(new Employee("Dan", "Smith", 2000, 400));
//        employeeList.add(new Employee("Pam", "Dickson", 1200, 450));
//        employeeList.add(new Employee("Walter", "White", 9999, 9999));

        Predicate<Employee> white = x -> x.lastName.equals("White");
        Predicate<Employee> sam = x -> x.firstName.equals("Sam");
        List<Employee> sorted = getEmployee(employeeList, white.or(sam));
        sorted.forEach(System.out::println);

        getEmployee(employeeList, white.or(sam).negate())
                .forEach(System.out::println);

        //premium salary
        /*int increment = 100;
        BiConsumer<LambdaAndStreams.Employee, Integer> premium = (x, y) -> x.setSalary(x.getSalary() + y);
        increaseSalary(employeeList, increment, premium);
        employeeList.forEach(System.out::println);*/

        //premium salary only for employee with high sales(>=2000)

        System.out.println("\nSalary before premium");
        employeeList.forEach(System.out::println);

//        premium(employeeList, 100, x -> x.getSale()>=2000, (x,y) -> x.setSalary(x.getSalary()+y));

        System.out.println("\nSalary after premium");
        employeeList.forEach(System.out::println);

        //combine
//        Integer combine = combine(employeeList, 0, Employee::getSale, Math::max);
//        System.out.println(combine);

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

    private static <T, R> R combine(List<T> employees,R zeroElem, Function<T,R> func, BinaryOperator<R> combiner) {
        R apply = null;
        for (T e :
                employees) {
            apply = combiner.apply(zeroElem, func.apply(e));
        }

        return apply;
    }

    private static <T, R> void premium(List<T> employees, R increment, Predicate<T> pred, BiConsumer<T,R> biCons) {
        for (T e :
                employees) {
           if(pred.test(e)) biCons.accept(e, increment);
        }
    }

}

