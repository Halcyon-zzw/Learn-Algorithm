package hot.test;

import mode.ListNode;
import mode.TreeNode;
import utils.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * TODO
 *
 * @author zhuzhiwei
 * @date 2024/5/14 17:43
 */
public class TestSolution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "ADOBECODEBANC";
        String t = "ABC";
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},{'.','.','2','.','7','.','.','.','.'},{'.','1','5','.','.','.','.','.','.'},{'.','.','.','.','.','2','.','.','.'},{'.','2','.','9','.','.','.','.','.'},{'.','.','4','.','.','.','.','.','.'}}
        ;
//        int[][] arr = {{1,2,3},{1,0,1},{7,8,9}};
//        int[][] arr = {{-4,-2147483648,6,-7,0},{-8,6,-8,-6,0},{2147483647,2,-9,-6,-10}};
//        int[][] arr = {{-2147483646,-2147483645},{2147483646,2147483647}};
//        int[][] arr = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
//        String str = "20*((17+13)*30)";
        String str = "1-(     -2)";
//        int num = solution.calculate3(str);

        int[] arr = {1,2,5,3,4,-1,6};
        ListNode listNode = ListNode.getListNode(arr);

        int[] arr1 = {3,9,20,15,7};
        int[] arr2 = {9,3,15,20,7};
        TreeNode root = TreeNode.create(arr);
        solution.flatten(root);
        System.out.println();
    }
}
