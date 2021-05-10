import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-15 10:45
 * @Version: 1.0
 */
public class MainTest {

    @Test
    public void test() {
        Map<Integer, Integer> map = new HashMap();
        map.put(2, 2);
        map.put(3, 3);
        map.put(1, 1);

        int i = nthUglyNumber(1000000000, 2,217983653 , 336916467);
        System.out.println(i);

    }

    public boolean queryString(String s, int N) {

        for (int i = 1; i <= N; i++) {
            String s1 = Integer.toBinaryString(i);
            if (!s.contains(s1)) {
                return false;
            }
        }
        return true;
    }

    public int nthUglyNumber2(int n, int a, int b, int c) {
        int i = 0;
        while (n > 0) {
            i ++;
            if (i %a == 0 || i % b == 0 || i % c == 0) {
                n--;
            }
        }
        return i;
    }


    public int nthUglyNumber(int n, int a, int b, int c) {

        return 0;

    }
}
