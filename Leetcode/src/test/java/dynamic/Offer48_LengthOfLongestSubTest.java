package dynamic;

import offer.dynamic.offer_48.impl.LengthOfLongestSubstring;
import offer.dynamic.offer_48.impl.LengthOfLongestSubstringByQueueImpl;
import offer.offer_1_50.offer_46.TranslateNum;
import org.junit.Before;
import org.junit.Test;
import utils.TestUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 18:05
 * @Version: 1.0
 */
public class Offer48_LengthOfLongestSubTest {

    Map<String, Integer> testMap = new HashMap<>();
    @Before
    public void init() {
        testMap.put("abcabcbb", 3);
        testMap.put("bbbbb", 1);
        testMap.put("pwwkew", 3);
    }

    @Test
    public void test() {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstringByQueueImpl();
        TestUtils.test(testMap, lengthOfLongestSubstring);
    }
}
