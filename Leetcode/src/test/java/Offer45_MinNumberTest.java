import offer.offer_1_50.offer_45.MinNumber;
import offer.offer_1_50.offer_45.impl.MinNumberImpl;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 11:10
 * @Version: 1.0
 */
public class Offer45_MinNumberTest {
    @Test
    public void test() {
        int[] arr = {0, 0 , 0};
        MinNumber minNumber = new MinNumberImpl();
        String s = minNumber.minNumber(arr);
        System.out.println(s);
    }
}
