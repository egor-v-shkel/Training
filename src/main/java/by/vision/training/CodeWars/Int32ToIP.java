package by.vision.training.CodeWars;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Take the following IPv4 address: 128.32.10.1
 *
 * This address has 4 octets where each octet is a single byte (or 8 bits).
 *
 * 1st octet 128 has the binary representation: 10000000
 * 2nd octet 32 has the binary representation: 00100000
 * 3rd octet 10 has the binary representation: 00001010
 * 4th octet 1 has the binary representation: 00000001
 * So 128.32.10.1 == 10000000.00100000.00001010.00000001
 *
 * Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361
 *
 * Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.
 *
 * Examples
 * 2149583361 ==> "128.32.10.1"
 * 32         ==> "0.0.0.32"
 * 0          ==> "0.0.0.0"
 */
public class Int32ToIP {

    public static String longToIP(long ip) {
        // Java doesn't have uint32, so here we use long to represent int32
        StringBuilder s1 = new StringBuilder(Long.toBinaryString(ip));

        int length = s1.length();
        for (int i = 0; i < 32- length; i++) {
            s1.insert(0, "0");
        }

        return Arrays.stream(s1.toString()
                .split("(?<=\\G.{8})"))
                .map(s -> Integer.parseInt(s, 2))
                .map(String::valueOf)
                .collect(Collectors.joining("."));
    }

}
