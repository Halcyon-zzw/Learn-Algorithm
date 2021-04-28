package dynamic;

import offer.dynamic.offer_51_TODO.ReversePairs;
import offer.dynamic.offer_51_TODO.impl.ReversePairsDynamicImpl;
import org.junit.Before;
import org.junit.Test;
import utils.TestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-24 22:52
 * @Version: 1.0
 */
public class Offer51_ReversePairsTest {
    Map<int[], Integer> map = new HashMap<>();

    @Before
    public void init() {
        int[] aa = {7,5,6,4};
        map.put(aa, 5);
        int[] a2 = {-5, -5};
        map.put(a2, 0);
    }

    @Test
    public void test() {

            long start = System.currentTimeMillis();
            TestUtils.test(map, ReversePairsDynamicImpl.class);
            long end = System.currentTimeMillis();
            System.out.println("耗时:" + (end - start));


    }
}
