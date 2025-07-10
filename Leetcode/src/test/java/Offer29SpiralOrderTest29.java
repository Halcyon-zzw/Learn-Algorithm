import old.offer.offer_1_50.offer_29.SpiralOrder;
import old.offer.offer_1_50.offer_29.impl.SpiralOrderIteration;
import org.junit.Test;
import utils.ArrayUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-21 14:29
 * @Version: 1.0
 */
public class Offer29SpiralOrderTest29 {
    @Test
    public void test() {
        int[][] martix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        SpiralOrder spiralOrder = new SpiralOrderIteration();
        int[] resultArr = spiralOrder.spiralOrder(martix);
        System.out.println(ArrayUtils.toString(resultArr));

    }
}
