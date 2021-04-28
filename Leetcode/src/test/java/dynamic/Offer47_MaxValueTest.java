package dynamic;

import offer.dynamic.offer_47.MaxValue;
import offer.dynamic.offer_47.MaxValueDynamicImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 16:44
 * @Version: 1.0
 */
public class Offer47_MaxValueTest {
    Map<int[][], Integer> testMap = new HashMap<>();


    @Before
    public void init() {
        int[][] arr1 = {
                {1,3,1},
                {1,5,1},
                {4,2,1}};
        testMap.put(arr1, 12);
        int[][] arr2 = {
                {1,2,5},
                {3,2,1}};
        testMap.put(arr2, 9);
    }

    @Test
    public void test() {
        MaxValue maxValue = new MaxValueDynamicImpl();
        System.out.println("INFO:=====测试结果=====");
        testMap.forEach((k, v) -> {
            int count = maxValue.maxValue(k);
            if (count != v) {
                String format = "ERROR: %s:%s   预期：<%s:%s>";
                System.out.println(String.format(format, k, count, k, v));
            }
        });
    }
}
