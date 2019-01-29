/*Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account the lowercase letters (a to z). First let us count the frequency of each lowercase letters in s1 and s2.

        s1 = "A aaaa bb c"

        s2 = "& aaa bbb c d"

        s1 has 4 'a', 2 'b', 1 'c'

        s2 has 3 'a', 3 'b', 1 'c', 1 'd'

        So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following we will not consider letters when the maximum of their occurrences is less than or equal to 1.

        We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands for string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.

        The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they appear with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.

        In the result, substrings (a substring is for example 2:nnnnn or 1:hhh; it contains the prefix) will be in decreasing order of their length and when they have the same length sorted in ascending lexicographic order (letters and digits - more precisely sorted by codepoint); the different groups will be separated by '/'. See examples and "Example Tests".

        Hopefully other examples can make this clearer.

        s1 = "my&friend&Paul has heavy hats! &"
        s2 = "my friend John has many many friends &"
        mix(s1, s2) --> "2:nnnnn/1:aaaa/1:hhh/2:mmm/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

        s1 = "mmmmm m nnnnn y&friend&Paul has heavy hats! &"
        s2 = "my frie n d Joh n has ma n y ma n y frie n ds n&"
        mix(s1, s2) --> "1:mmmmmm/=:nnnnnn/1:aaaa/1:hhh/2:yyy/2:dd/2:ff/2:ii/2:rr/=:ee/=:ss"

        s1="Are the kids at home? aaaaa fffff"
        s2="Yes they are here! aaaaa fffff"
        mix(s1, s2) --> "=:aaaaaa/2:eeeee/=:fffff/1:tt/2:rr/=:hh"*/

package CodeWars;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class Mixing {

    public static String mix(String s1, String s2) {

        //edge case
        if (s1 == s2) return "";

        String srtS1 = getString(s1);
        String srtS2 = getString(s2);
        System.out.println("S1 string:"+srtS1);
        System.out.println("S2 string:"+srtS2);
        
        int a = 'z';
        System.out.println(a);

        return "";

        /*int[] alphabet = new char[26];
        int[] letterContainS1 = new int[26];
        int[] letterContainS2 = new int[26];

        //fill alphabet with chars
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a'+i);
        }

        //count occurrences of lowercase char
        for (int i = 0; i < Math.max(s1.length(), s2.length()); i++) {
            if (i < s1.length() && s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z'){
                ++letterContainS1[s1.charAt(i)-97];
            }
            if (i < s2.length() && s2.charAt(i) >= 'a' && s2.charAt(i) <= 'z'){
                ++letterContainS2[s2.charAt(i)-97];
            }
        }

        String pattern1 = "1:";
        String pattern2 = "2:";
        String patternEqual = "=:";

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < 26; i++) {
            if (Math.max(letterContainS1[i], letterContainS2[i]) <= 1) continue;
            if (letterContainS1[i] > letterContainS2[i]) sb.append(pattern1);
            if (letterContainS1[i] < letterContainS2[i]) sb.append(pattern2);
            else sb.append(patternEqual);
            sb.append(alphabet[i]);
            if (i == 25) break;
            sb.append('/');
        }

        return sb.toString();*/
    }

    @NotNull
    private static String getString(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' || chars[i] <= 'z') chars[i] = null;
        }
        
        Arrays.sort(chars);
        String sortedStr = new String(chars);
        System.out.println(sortedStr);
        return sortedStr;
    }
}