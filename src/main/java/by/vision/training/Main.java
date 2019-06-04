package by.vision.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Main {
    public static void main(String args[]) {


        ArrayList<Person> names = new ArrayList<Person>();
        names.add(new Person("E", "Q", "M"));
        names.add(new Person("E", "Q", "N"));
        names.add(new Person("B", "P", "S"));
        names.add(new Person("C", "K", "Q"));

        Iterator iter1 = names.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
        Collections.sort(names, new PersonComparator());
        Iterator iter2 = names.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }


        /*ArrayList<by.vision.training.GraduationCeremony> grad = new ArrayList<by.vision.training.GraduationCeremony>();
        grad.add(new by.vision.training.GraduationCeremony("bntu", "ATF", "8" ));
        grad.add(new by.vision.training.GraduationCeremony("bntu", "ATF", "1" ));
        grad.add(new by.vision.training.GraduationCeremony("bntu", "GNU", "1" ));
        grad.add(new by.vision.training.GraduationCeremony("mglu", "ATF", "1" ));
        grad.add(new by.vision.training.GraduationCeremony("mglu", "NFC", "9" ));*/

    }
}

