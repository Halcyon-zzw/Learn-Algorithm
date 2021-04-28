import org.junit.Test;
import utils.SearchUtils;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-16 11:02
 * @Version: 1.0
 */
public class SearchUtilsTest {

    @Test
    public void testBinarySearch() {
        int[] ints = SearchUtils.generateOrderlyData(10);

        int i = SearchUtils.binarySearch(ints, 3);
        System.out.println(i);
    }



}
