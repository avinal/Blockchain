// do not remove imports

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

class ArrayUtils {
    public static <T> T[] invert(T[] array) {
        int len = array.length;
        for (int i = 0; i < len / 2; i++) {
            T temp = array[i];
            array[i] = array[len - i - 1];
            array[len - i - 1] = temp;
        }
        return array;
    }
}