package CodeWars;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Mixing {

    static char pref1 = '1';
    static char pref2 = '2';
    static char prefEq = '=';

    public static String mix(String s1, String s2) {

        if (s1.equals(s2) || s1 == null || s2 == null) return "";

        Map<Character, Char> map1 = new ConcurrentHashMap<>();
        Map<Character, Char> map2 = new ConcurrentHashMap<>();

        fillMap(s1, map1, pref1);
        fillMap(s2, map2, pref2);

        remove(map1);
        remove(map2);

        map1.forEach((k1, v1) -> map2.merge(k1, v1, Mixing::condition));
        StringBuilder sb = new StringBuilder();
        entriesSortedByValues(map2).forEach(entry -> {

            String rep = String.format("%" + entry.getValue().freq + "s", "").replace(' ', entry.getValue().aChar);
            sb.append(String.format("%c:%s/", entry.getValue().prefix, rep));
        });
        return sb.toString().substring(0, sb.length()-1);
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

    private static void remove(Map<Character, Char> map) {
        map.forEach((key, value) -> {
            if (value.freq < 2) map.remove(key);
        });
    }

    private static void fillMap(String s, Map<Character, Char> map, char pref) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c <= 'z') {
                if (!map.containsKey(c)) {
                    Char newChar = new Char();
                    newChar.prefix = pref;
                    newChar.aChar = c;
                    map.put(c, newChar);
                }
                Char curChar = map.get(c);
                ++curChar.freq;
            }
        }
    }

    static <K,V extends Comparable<? super V>>
    SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<>(
                Comparator.comparing(Map.Entry::getValue)
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    static class Char implements Comparable<Char>{
        char aChar;
        int freq;
        char prefix;

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