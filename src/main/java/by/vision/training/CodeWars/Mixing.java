/**/

package by.vision.training.CodeWars;

import java.util.*;

/**
 * Given two strings s1 and s2, we want to visualize how different the two strings are.
 * We will only take into account the lowercase letters (a to z).
 * First let us count the frequency of each lowercase letters in s1 and s2.
 * <p>
 * s1 = "A aaaa bb c"
 * <p>
 * s2 = "& aaa bbb c d"
 * <p>
 * s1 has 4 'a', 2 'b', 1 'c'
 * <p>
 * s2 has 3 'a', 3 'b', 1 'c', 1 'd'
 * <p>
 * So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2.
 * In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.
 * We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for
 * string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the
 * maximum for b is 3.
 * The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum
 * if this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they
 * appear with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.
 * In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it contains the prefix) will be in decreasing
 * order of their length and when they have the same length sorted in ascending lexicographic order
 * (letters and digits - more precisely sorted by codepoint); the different groups will be separated by '/'.
 * See examples and "Example Tests".
 * Hopefully other examples can make this clearer.
 * <p>
 * s1 = "my&friend&Paul has heavy hats! &"
 * s2 = "my friend John has many many friends &"
 * mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * <p>
 * s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
 * s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
 * mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"
 * <p>
 * s1="Are the kids at home? aaaaa fffff"
 * s2="Yes they are here! aaaaa fffff"
 * mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"
 */
public class Mixing {

    static char pref1 = '1';
    static char pref2 = '2';
    static char prefEq = '=';

    static List<Char> list1;
    static List<Char> list2;

    public static String mix(String s1, String s2) {

        if (s1.equals(s2) || s1 == null || s2 == null) return "";

        int alpNum = 26;

        list1 = new ArrayList<>(alpNum);
        list2 = new ArrayList<>(alpNum);

        fillList(s1, list1, pref1);
        fillList(s2, list2, pref2);

        merge(list1, list2);

        Comparator<Char> length = (x,y) -> y.freq-x.freq;
        Comparator<Char> type_value = Comparator.comparingInt(x -> x.aChar);

        //return list1.stream().sorted(length.thenComparing(type_value)).collect(Collectors.groupingBy(Char c));

        /*StringBuilder sb = new StringBuilder();
        list1.sort().forEach(entry -> {

            String rep = String.format("%" + entry.getValue().freq + "s", "").replace(' ', entry.getValue().aChar);
            sb.append(String.format("%c:%s/", entry.getValue().prefix, rep));
        });
        return sb.toString().substring(0, sb.length()-1);*/
        return  null;
    }

    private static void merge(List<Char> list1, List<Char> list2) {
        for (int i = 0; i <list1.size(); i++) {
            Char aChar1 = list1.get(i);
            Char aChar2 = list2.get(i);
            if (aChar1.freq < aChar2.freq) list1.add(i, aChar2);
            if (aChar1.freq == aChar2.freq) aChar1.prefix = prefEq;
        }
    }

    private static Char condition(Char oldVal, Char newVal) {
        int oldFreq = oldVal.freq;
        int newFreq = newVal.freq;
        if (oldFreq > newFreq){
            oldVal.prefix = pref2;
            return oldVal;
        } else if (oldFreq < newFreq){
            oldVal.prefix = pref1;
            return newVal;
        } else {
            oldVal.prefix = prefEq;
            return  oldVal;
        }
    }

    private static void fillList(String s, List<Char> list, char pref) {
        s.chars().filter(c -> c >= 'a' && c <= 'z' ).forEach(c -> {
            Char curChar = list.get(c - 61);
            if (curChar == null) list.add(new Char((char) c, pref));
            curChar.freq++;
        });
    }

    static class Char implements Comparable<Char>{
        char aChar;
        int freq = 0;
        char prefix;

        public Char(char aChar, char prefix) {
            this.aChar = aChar;
            this.prefix = prefix;
        }

        /**
         * Order:
         * 1. Frequency
         * 2. Prefix ("1" > "2" > "=")
         * 3. Character alphabetically
         *
         * @param c
         * @return
         */
        @Override
        public int compareTo(Char c) {


            return
                    //check freq
                    (this.freq > c.freq)?-1:
                    (this.freq < c.freq)?1:
                            //check prefix
                            (this.prefix > c.prefix)?1:
                                    (this.prefix < c.prefix)?-1:
                                            //check alphabetically
                                            (this.aChar > c.aChar)?1:
                                                    (this.aChar < c.aChar)?-1:0;


        }
    }

}

