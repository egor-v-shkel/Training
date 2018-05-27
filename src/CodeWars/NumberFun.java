package CodeWars;

public class NumberFun {
    public static long findNextSquare(long sq) {
        double sqRoot = Math.sqrt(sq);
        Double d = sqRoot;
        int intVal = d.intValue();
        if (sqRoot-intVal > 0) return -1;
        return (long) Math.pow(intVal+1, 2);
    }
}