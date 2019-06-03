package JavaCore.Collections;

import java.util.*;

public class ArrayListTraining {

    List<Integer> list = new ArrayList<>();

    public void doSomething() {
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator listIter = list.listIterator();
/*
        for (Integer i:list
             ) {
            System.out.println(listIter.next());
        }
*/
    }

}

class ArrayListStarter{
    public static void main(String[] args) {
        ArrayListTraining tr = new ArrayListTraining();
        tr.doSomething();
    }
}
