import offer.offer_1_50.offer_43.CountDigitOne;
import offer.offer_1_50.offer_43.impl.CountDigitOneDynamicImpl;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 9:34
 * @Version: 1.0
 */
public class Offer43_CountDigitOneTest {
    @Test
    public void test() {
        CountDigitOne countDigitOne = new CountDigitOneDynamicImpl();
        int count = countDigitOne.countDigitOne(100);
        System.out.println(count);
    }
}
