package DesignPatterns.Strategy;

public class Mute implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("No sound!");
    }
}
