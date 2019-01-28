import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Person implements Comparable {
    String firstName, lastName, midName;

    public Person(String f, String l, String m) {
        this.firstName = f;
        this.lastName = l;
        this.midName = m;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "[ firstname=" + firstName + ",lastname=" + lastName + ", midName=" + midName + "]";
    }

    public int compareTo(Object obj) {
        Person emp = (Person) obj;
        int deptComp = firstName.compareTo(emp.getFirstName());

        return ((deptComp == 0) ? lastName.compareTo(emp.getLastName()) : deptComp);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person emp = (Person) obj;
        return firstName.equals(emp.getFirstName()) && lastName.equals(emp.getLastName());
    }
}

class PersonComparator implements Comparator<Person> {
    public int compare(Person emp1, Person emp2) {

        int value1 = emp1.firstName.compareTo(emp2.firstName);
        if (value1 == 0) {
            int value2 = emp1.lastName.compareTo(emp2.lastName);
            if (value2 == 0) {
                return emp1.midName.compareTo(emp2.midName);
            } else {
                return value2;
            }
        }
        return value1;
    }
}
