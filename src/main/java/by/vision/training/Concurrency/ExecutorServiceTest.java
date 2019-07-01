package by.vision.training.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ExecutorServiceTest {
    static Thread tr;

    public static void main(String[] args) throws InterruptedException {

        tr = new Thread(new MyTestThread());
        tr.setDaemon(true);
/*
        tr.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/

        final int nThreads = 4;
        ExecutorService service = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < 5; i++) {
            service.execute(tr);
            System.out.println("!!!Task added to queue!!!");
        }
        service.shutdown();
        service.awaitTermination(30, TimeUnit.SECONDS);

        System.out.println("End of main thread");

    }

}

class MyTestThread implements Runnable{

    long startTime = System.currentTimeMillis();

    @Override
    public void run() {
        final String randomLayout = ConsoleColors.randomiser.colorText();
        final String threadName = Thread.currentThread().getName();
        System.out.println(randomLayout+"Task added to "+ threadName);

        Stream.generate(()->randomLayout+"run "+threadName)
                .map(x -> (System.currentTimeMillis() - startTime)+" "+x)
                .limit(10)
                .forEach(System.out::println);

        System.out.println(randomLayout +"End of task from "+ threadName);
    }
}
