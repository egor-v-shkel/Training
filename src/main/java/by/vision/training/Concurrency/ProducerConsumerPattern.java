package by.vision.training.Concurrency;

import by.vision.training.LambdaAndStreams.Employee;
import by.vision.training.LambdaAndStreams.EmployeeProvider;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerPattern {
    private static BlockingQueue<Employee> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();

    }

    private static class Producer implements Runnable{

        List<Employee> employees = EmployeeProvider.getRandomEmployeesList(100);

        @Override
        public void run() {
            produce();
        }

        private void produce()  {
            employees.forEach(e -> {
                try {
                    queue.put(e);
                    System.out.println(ConsoleColors.randomiser.colorText()+"producing "+e+". Queue size is "+queue.size());
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    private static class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            while (true){
                final String employeeInfo = queue.take().toString();
                System.out.println(ConsoleColors.randomiser.colorText()+employeeInfo+" was consumed");
            }
        }
    }

}
