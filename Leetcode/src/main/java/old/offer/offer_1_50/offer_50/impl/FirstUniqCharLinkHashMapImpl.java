package old.offer.offer_1_50.offer_50.impl;

import old.offer.offer_1_50.offer_50.FirstUniqChar;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-24 22:22
 * @Version: 1.0
 */
public class FirstUniqCharLinkHashMapImpl implements FirstUniqChar {
    @Override
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
