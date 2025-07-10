import old.offer.offer_1_50.offer_40.GetLeastNumbers;
import old.offer.offer_1_50.offer_40.GetLeastNumbersByPriorityQueueImpl;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 18:15
 * @Version: 1.0
 */
public class Offer40_GetLeastNumbersTest {
    GetLeastNumbers getLeastNumbers = null;
    int[] arr = {0,0,1,2,4,2,2,3,1,4};
    int k = 8;


    @Test
    public void testQueue() {
        getLeastNumbers = new GetLeastNumbersByPriorityQueueImpl();
        int[] leastNumbers = getLeastNumbers.getLeastNumbers(arr, k);
        for (int leastNumber : leastNumbers) {
            System.out.println(leastNumber);
        }

    }
}
