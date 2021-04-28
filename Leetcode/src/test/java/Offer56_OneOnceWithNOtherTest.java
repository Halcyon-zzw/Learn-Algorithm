import offer.offer_56.OneOnceWithNOther;
import offer.offer_56.SingleNumbersOneOnceWithNImpl;
import org.junit.Test;
import utils.TestUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-25 19:14
 * @Version: 1.0
 */
public class Offer56_OneOnceWithNOtherTest {
    @Test
    public void test() {
        TestUtils.test(SingleNumbersOneOnceWithNImpl.class, new int[]{3,4,3,3});
    }
}
