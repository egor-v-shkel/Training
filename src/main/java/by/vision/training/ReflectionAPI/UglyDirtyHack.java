package by.vision.training.ReflectionAPI;



import sun.misc.Unsafe;

import java.io.IOException;
import java.lang.reflect.Field;

public class UglyDirtyHack{

    public static void main(String[] args) {

        getUnsafe().throwException(new IOException("This is checked exception"));

    }

    public static Unsafe getUnsafe() {

        Unsafe unsafe = null;

        try {

            Field f = Unsafe.class.getDeclaredField("theUnsafe");

            f.setAccessible(true);

            unsafe = (Unsafe) f.get(null);

        } catch (ReflectiveOperationException e) {

            System.out.println("Who cares");

        }

        return unsafe;

    }

}
