package normal;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-06-16 16:53
 * @Version: 1.0
 */
public class Test {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < astr.length(); i++) {
            char c = astr.charAt(i);
            if (set.contains(c)) {
                return false;
            }
            set.add(c);
        }
        return true;
    }
}
