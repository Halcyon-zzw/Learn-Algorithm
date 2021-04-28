package dynamic;

import offer.dynamic.offer_49.NthUglyNumber;
import offer.dynamic.offer_49.impl.NthUglyNumberByDynamicImpl;
import org.junit.Before;
import org.junit.Test;
import utils.TestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 18:51
 * @Version: 1.0
 */
public class Offer49_NthUglyNumberTest {
    Map<Integer, Integer> map = new HashMap<>();

    @Before
    public void before() {
        map.put(10, 12);
    }

    @Test
    public void test() {
        NthUglyNumber nthUglyNumber = new NthUglyNumberByDynamicImpl();
        TestUtils.test(map, nthUglyNumber);
    }
}
