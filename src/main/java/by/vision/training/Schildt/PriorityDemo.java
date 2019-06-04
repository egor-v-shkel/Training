package by.vision.training.Schildt;

class Priority implements Runnable{
    int count;
    Thread thrd;
    static boolean sync = false;
    static String currThrdName;
    Priority( String name){
        thrd = new Thread(this, name);
        currThrdName = name;
        count = 0;
    }

    @Override
    public void run() {
        System.out.println("Start thread "+thrd.getName());
        do {
            count++;
            if (currThrdName.compareTo(thrd.getName()) != 0) {
                currThrdName = thrd.getName();
                System.out.println("Current running thread - "+currThrdName);
            }
        } while (!sync && count < 1000);
        sync = true;
        System.out.println(thrd.getName()+" ended");
    }
}

public class PriorityDemo {
    public static void main(String args[]) {
        Priority mt1 = new Priority("High priority");
        Priority mt2 = new Priority("Low priority");
        mt1.thrd.setPriority(Thread.NORM_PRIORITY+2);
        mt2.thrd.setPriority(Thread.NORM_PRIORITY-2);
        mt1.thrd.start();
        mt2.thrd.start();
        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Counter of high priority thread = "+mt1.count);
        System.out.println("Counter of low priority thread = "+mt2.count);
    }
}
