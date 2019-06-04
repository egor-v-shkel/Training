package DesignPatterns.Strategy;

public class FLyNoWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}
