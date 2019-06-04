package by.vision.training.DesignPatterns.Strategy;

public class Test {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        action(mallard);

        //dynamically changing behaviour
        mallard.setFlyBehavior(new FLyNoWings());
        mallard.setQuackBehavior(new Mute());
        action(mallard);
    }

    private static void action(Duck mallard) {
        mallard.performQuack();
        mallard.performFly();
    }

}
