import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-16 9:39
 * @Version: 1.0
 */
public class StrTest {
    StrAlgorithm strAlgorithm = new StrAlgorithm();
    @Test
    public void testLeagthestSubStr() {
        int abcabcbb = strAlgorithm.lengthOfLongestSubstring1("abcabcbb");
        System.out.println(abcabcbb);
    }
}
