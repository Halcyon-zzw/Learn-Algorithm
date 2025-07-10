import mode.ListNode;
import old.offer.offer_1_50.offer_25.MergeTwoLists;
import old.offer.offer_1_50.offer_25.impl.MergeTwoListsByMergeOneImpl;
import org.junit.Test;

/**
 * TODO
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 15:25
 * @Version: 1.0
 */
public class Offer25_MergeTwoListsTest {
    @Test
    public void test() {
        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1,3, 4};
//        int[] arr = {1};
        ListNode head1 = ListNode.getListNode(arr1);
        ListNode head2 = ListNode.getListNode(arr2);
        MergeTwoLists mergeTwoLists = new MergeTwoListsByMergeOneImpl();
        final ListNode listNode = mergeTwoLists.mergeTwoLists(head1, head2);
        System.out.println(listNode);

    }
}
