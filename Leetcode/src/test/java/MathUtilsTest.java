import org.junit.Test;
import utils.MathUtil;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-15 14:14
 * @Version: 1.0
 */
public class MathUtilsTest {

    @Test
    public void testGcd() {
        long gcb = MathUtil.gcb(99L, 3L);
        System.out.println(gcb);
    }
}
