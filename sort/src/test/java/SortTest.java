import int_type.SortInterface;
import int_type.impl.QuickSort;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-05-08 14:02
 * @Version: 1.0
 */
public class SortTest {

    int[] arr = null;

    @Before
    public void create() {
        int size = 10;
        Random random = new Random();
        arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
    }

    @Test
    public void test() {
        for (int i : arr) {
            System.out.print(i);
            System.out.print("\t");
        }
        SortInterface sortInterface = new QuickSort();
        sortInterface.apply(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i);
            System.out.print("\t");
        }
    }
}
