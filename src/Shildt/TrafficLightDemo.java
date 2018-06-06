package Shildt;

public class TrafficLightDemo {
    public static void main(String args[]) {
        TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.GREEN);
        for (int i = 0; i < 9; i++) {
            System.out.println(t1.getColor());
            t1.waitForChange();
        }

        t1.cancel();
    }
}

enum TrafficLightColor{
    RED, GREEN, YELLOW
}

class TrafficLightSimulator implements Runnable{
    Thread thrd;
    TrafficLightColor tlc;
    boolean stop = false;
    boolean changed = false;

    TrafficLightSimulator(TrafficLightColor init) {
        tlc = init;

        thrd = new Thread(this);
        thrd.start();
    }

    TrafficLightSimulator() {
        tlc = TrafficLightColor.RED;

        thrd = new Thread(this);
        thrd.start();
    }

    @Override
    public void run() {
        while (!stop){

            try {
                switch (tlc){
                    case RED:
                        Thread.sleep(12000);
                        break;
                    case GREEN:
                        Thread.sleep(10000);
                        break;
                    case YELLOW:
                        Thread.sleep(2000);
                        break;
                }
            } catch (InterruptedException e){
                System.out.println(e);
            }
            changeColor();
        }
    }

    synchronized void changeColor(){
        switch (tlc){
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
        }

        changed = true;
        notify();
    }

    synchronized void waitForChange(){
        try {
            while (!changed)
                wait();
            changed = false;
        } catch (InterruptedException e){
            System.out.println(e);
        }
    }

    TrafficLightColor getColor(){
        return tlc;
    }

    void cancel(){
        stop = true;
    }

}
