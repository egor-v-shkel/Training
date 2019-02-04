package Schildt.LambdaExpressions;

@FunctionalInterface
interface LambdaI{

    boolean func(String s);

}

class RefDemo{

    private String str;

    RefDemo(){
        this.str = "Default string";
    }

    RefDemo(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    boolean isPartOf(String half){
        return str.contains(half);
    }

    boolean haveEightChars(String str){
        return str.length() == 8;
    }
}

class MethodReference {
    public static void main(String[] args) {

        boolean part;

        RefDemo eightTest = new RefDemo();
        System.out.println(eightTest.getStr());
        RefDemo rDemo1 = new RefDemo("Строка String");
        RefDemo rDemo2 = new RefDemo("Здесь нет стринг");

        LambdaI lambDem = rDemo1::isPartOf;
        part = lambDem.func("String");
        System.out.println(part);


        lambDem = rDemo2::isPartOf;
        part = lambDem.func("12345678");
        System.out.println(part);

        lambDem = eightTest::haveEightChars;
        part = lambDem.func("12345678");
        System.out.println("Common string has 8 chars "+part);

    }
}
