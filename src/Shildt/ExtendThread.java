package Shildt;

public class ExtendThread {
    public static void main(String args[]) {
        System.out.println("Run main thread");
        MyThread mt1 = new MyThread("Child #1");
        MyThread mt2 = new MyThread("Child #2");
        MyThread mt3 = new MyThread("Child #3");
        do {
            System.out.println(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (mt1.isAlive() || mt2.isAlive() || mt3.isAlive());
        System.out.println("End Of main thread");
    }
}

class MyThread extends Thread{
    MyThread(String name){
        super(name);
        start();
    }
    public void run(){
        System.out.println("Start thread - "+getName());
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(400);
                System.out.println("Counter in thread "+getName()+" is "+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of thread"+getName());
    }
}
