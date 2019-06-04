package Schildt;

class SummArray{
    private int sum;
    /*synchronized*/ int summArr(int[] arr){
        sum = 0;
        for (int i1 : arr) {
            sum += i1;
            System.out.println("Current summ for " + Thread.currentThread().getName() + " is - " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Main thread interruption");
            }
        }

        return sum;
    }
}

class MyThread implements Runnable {
    Thread thrd;
    static final SummArray sa = new SummArray();
    int[] a;
    int answer;

    MyThread(String name, int[] nums){
        thrd = new Thread(this, name);
        a = nums;
        thrd.start();
    }

    public void run() {
        System.out.println("Run "+thrd.getName());
        synchronized (sa){
            answer = sa.summArr(a);
        }

        System.out.println("Sum for " + thrd.getName() + " is " + answer);
        System.out.println("End of thread "+thrd.getName());
    }
}

class Sync {
    public static void main(String[] args){
        int[] a = {1, 2, 3, 4, 5};
        MyThread1 mt1 = new MyThread1("Thread #1");
        MyThread1 mt2 = new MyThread1("Thread #2");
    }
}
