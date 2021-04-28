package dynamic;

import offer.offer_1_50.offer_46.TranslateNum;
import offer.offer_1_50.offer_46.impl.TranslateNumByDynamicImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 15:30
 * @Version: 1.0
 */
public class Offer46_TranslateNumTest {
    Map<Integer, Integer> testMap = new HashMap<>();
    @Before
    public void init() {
        testMap.put(12218, 8);
        testMap.put(12258, 5);
        testMap.put(26, 1);
        testMap.put(506, 1);
        testMap.put(1, 1);
    }
    @Test
    public void test() {
        TranslateNum translateNum = new TranslateNumByDynamicImpl();
        testMap.forEach((k, v) -> {
            int count = translateNum.translateNum(k);
            if (count != v) {
                String format = "ERROR: %s:%s   预期：<%s:%s>";
                System.out.println(String.format(format, k, count, k, v));
            }
        });
        System.out.println("=========");
        int num = 26;
        int count = translateNum.translateNum(num);
        System.out.println(num + "翻译数量：" + count);
    }
}
