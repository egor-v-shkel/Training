package Schildt.LambdaExpressions;

@FunctionalInterface
interface ConstrRefDemoInterface{

    RefDemo constr();

}

public class ConstrRefDemo {

    public static void main(String[] args) {

        ConstrRefDemoInterface refConstr = RefDemo::new;
        RefDemo obj = refConstr.constr();
        System.out.println(obj.getStr());

    }

}
