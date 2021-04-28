import offer.offer_1_50.offer_13.MovingCount;
import offer.offer_1_50.offer_13.impl.MovingCountByBfs;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-19 10:49
 * @Version: 1.0
 */
public class MovingCountTest {

    @Test
    public void test() {
        MovingCount movingCount = new MovingCountByBfs();
        int i = movingCount.movingCount(16, 8, 4);
        System.out.println(i);

    }
}
