package by.vision.training;

class ThreadTest implements Runnable {
    Thread thrd;
    ThreadTest(String name){
        thrd = new Thread(this, name);
        thrd.start();
    }
    public void run(){
        System.out.println("Start thread - "+thrd.getName());
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(500);
                System.out.println("Counter in thread "+thrd.getName()+" is "+i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of process"+thrd.getName());
    }
}
