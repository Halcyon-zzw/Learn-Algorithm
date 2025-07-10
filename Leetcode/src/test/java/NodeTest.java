import mode.Node;
import old.offer.offer_1_50.offer_35.CopyRandomList;
import old.offer.offer_1_50.offer_35.impl.CopyRandomListBySplitImpl;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-22 14:56
 * @Version: 1.0
 */
public class NodeTest {
    @Test
    public void testcopyRandomList35() {
        int[] arr = {7, 13, 11, 10, 1};
        Node listNode = Node.getListNode(arr);
        CopyRandomList copyRandomList = new CopyRandomListBySplitImpl();
        copyRandomList.copyRandomList(listNode);
        System.out.println();
    }
}
