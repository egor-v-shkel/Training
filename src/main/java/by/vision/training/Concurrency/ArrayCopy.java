package by.vision.training.Concurrency;

import java.util.ArrayList;
import java.util.List;

import static by.vision.training.Concurrency.ConsoleColors.*;

public class ArrayCopy {

    int[] arr1 = {1, 2, 3, 4, 5};
    int[] arr2 = {6, 7, 8, 9, 10};
    List<Integer> integerList1 = new ArrayList<>(arr1.length);
    List<Integer> integerList2 = new ArrayList<>(arr2.length);
    final Object lock1 = new Object();
    final Object lock2 = new Object();


    public static void main(String[] args) {
        new ArrayCopy().copy();
    }

    private void copy() {

        Thread copy1 = new Thread(new CopyFirstArray());
        Thread copy2 = new Thread(new CopySecondArray());
        copy1.start();
        copy2.start();
        try {
            copy1.join();
            copy2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(ANSI_PURPLE+"End of copy");

    }

    class CopyFirstArray implements Runnable{

        @Override
        public void run() {
            copySecond();
        }
    }

    class CopySecondArray implements Runnable{

        @Override
        public void run() {
            copyFirst();
        }
    }

    private synchronized void copyFirst() {
        synchronized (lock1) {
            for (int i = 0; i < arr2.length; i++) {
                integerList2.add(arr2[i]);
                System.out.println(ANSI_BLUE+integerList2);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(ANSI_BLUE+"Second array has copied");
        }
    }

    private void copySecond() {

        synchronized (lock2) {
            for (int i = 0; i < arr1.length; i++) {
                integerList1.add(arr1[i]);
                System.out.println(ANSI_RED+integerList1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(ANSI_RED+"First array has copied");
        }
    }

}
