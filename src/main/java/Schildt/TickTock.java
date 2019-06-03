package Schildt;

public class TickTock {
    String state; // contains info about clock state

    synchronized void tick(boolean running){
        if(!running){ //stop the ticker
            state = "ticked";
            notify(); //notify waiting threads
            return;
        }

        System.out.print("Tick ");

        try{
            Thread.sleep(500);
        } catch(InterruptedException ex){
            System.out.println("Thread running has been interrupted");
        }

        state = "ticked"; //put current state after "tick"

        notify(); // Let the method tock() begin

        try{
            while(!state.equals("tocked"))
                wait(); //wait until method tock() is finished
        }
        catch (InterruptedException ex){
            System.out.println("Thread interruption");
        }
    }

    synchronized void tock(boolean running){
        if(!running){ // stop ticker
            state = "tocked";
            notify(); //notify waiting threads
            return;
        }

        System.out.println("Tock");

        try{
            Thread.sleep(500);
        } catch(InterruptedException ex){
            System.out.println("Thread running has been interrupted");
        }

        state = "tocked"; //put current state after "tock"

        notify(); //let the method tick() begin

        try {
            while (!state.equals("ticked"))
                wait(); // wait until method tick() is finished
        }
        catch (InterruptedException ex){
            System.out.println("Thread interruption");
        }
    }
}

class MyThreadTick implements Runnable{
    Thread thrd;
    TickTock tickTock;

    //create new thread:
    MyThreadTick(String name, TickTock tock){
        thrd = new Thread(this, name);
        tickTock = tock;
        thrd.start();
    }

    //Start new thread:
    public void run(){
        if (thrd.getName().compareTo("Tick") == 0){
            for (int i = 0; i < 5; i++) tickTock.tick(true);
            tickTock.tick(false);
        }
        else{
            for (int i = 0; i < 5; i++) tickTock.tock(true);
            tickTock.tock(false);
        }
    }
}

class ThreadCom {
    public static void main(String arge[]){
        TickTock tt = new TickTock();
        MyThreadTick mt1 = new MyThreadTick("Tick", tt);
        MyThreadTick mt2 = new MyThreadTick("Tock", tt);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch (InterruptedException ex){
            System.out.println("Main thread interruption");
        }
    }
}