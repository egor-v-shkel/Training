package by.vision.training.CodeWars;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Int32ToIPTest {
    @Test
    public void sampleTest() {
        assertEquals("128.114.17.104", Int32ToIP.longToIP(2154959208L));
        assertEquals("0.0.0.0", Int32ToIP.longToIP(0));
        assertEquals("128.32.10.1", Int32ToIP.longToIP(2149583361L));
    }
}
