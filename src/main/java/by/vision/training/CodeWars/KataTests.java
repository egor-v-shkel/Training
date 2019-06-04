package by.vision.training.CodeWars;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.*;

public class KataTests {
    @Test
    public void BasicTests() {
        assertEquals(3, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 1, 2 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
        assertEquals(2, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 5, 2, 9 }, new Object[] { 4, 5, 1, 1 }, new Object[] { 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));
        assertEquals(2, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { null }, new Object[] { null, null, null } } ));
        assertEquals(5, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 'a', 'a', 'a' }, new Object[] { 'a', 'a' }, new Object[] { 'a', 'a', 'a', 'a' }, new Object[] { 'a' }, new Object[] { 'a', 'a', 'a', 'a', 'a', 'a' }} ));

        // not starting with length 1
        assertEquals(4, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 5, 2, 9 }, new Object[] { 4, 5, 1, 1, 5, 6}, new Object[] { 1, 1 }, new Object[] { 5, 6, 7, 8, 9 }} ));

        // edge cases
        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][] { }));
        assertEquals(0, Kata.getLengthOfMissingArray(null));

        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { }, new Object[] { 1, 2, 2 } } ));
        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 1, 2, 2 }, null} ));
        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][] { null, new Object[] { 1, 2, 2 } } ));
        assertEquals(0, Kata.getLengthOfMissingArray(new Object[][] { new Object[] { 1, 2, 2 }, new Object[] { }} ));
    }

    @Test
    public void RandomTests() {
        for(int r=0;r<40;r++) {
            int startLength = (int)Math.floor(Math.random() * 5);
            int endLength = (int)Math.floor(Math.random() * 9) + startLength + 3;

            int missingLength = (int)Math.floor(Math.random() * (endLength - startLength - 1)) + startLength + 1;

            Object[][] arrayOfArrays = new Object[endLength-startLength][];

            int count = 0;
            for(int i=startLength;i<=endLength;i++)
            {
                if(i != missingLength)
                {
                    Object[] arr = new Object[i];
                    for(int p=0;p<i;p++)
                    {
                        arr[p] = (int)Math.floor(Math.random() * 5);
                    }
                    arrayOfArrays[count] = arr;
                    count++;
                }
            }

            if(startLength == 0)
            {
                missingLength = 0;
            }

            for(int i=0;i<endLength-startLength;i++)
            {
                int rand1 = (int)Math.floor(Math.random() * (endLength-startLength));
                int rand2 = (int)Math.floor(Math.random() * (endLength-startLength));

                Object[] temp = arrayOfArrays[rand1];
                arrayOfArrays[rand1] = arrayOfArrays[rand2];
                arrayOfArrays[rand2] = temp;
            }

            String message = "Wrong for " + Arrays.deepToString(arrayOfArrays);
            assertEquals(message, missingLength, Kata.getLengthOfMissingArray(arrayOfArrays));
        }
    }
}