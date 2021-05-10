import mode.ListNode;
import offer.offer_1_50.offer_24.ReverseListInterface;
import offer.offer_1_50.offer_24.impl.ReverseListByRecursionImpl;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 14:55
 * @Version: 1.0
 */
public class Offer24ReverseListTest24 {
    @Test
    public void name() {
                int[] arr = {1,2,3,4,5};
//        int[] arr = {1};
        final ListNode head = ListNode.getListNode(arr);
        ReverseListInterface reverseList = new ReverseListByRecursionImpl();
        final ListNode newListNode = reverseList.reverseList(head);
        System.out.println(newListNode);
    }
}
