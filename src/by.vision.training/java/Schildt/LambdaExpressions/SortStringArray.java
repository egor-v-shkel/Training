package Schildt.LambdaExpressions;

import java.util.Comparator;

public class SortStringArray implements Comparator<String> {

    public static void main(String[] args) {

    }

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
