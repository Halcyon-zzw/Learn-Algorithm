package offer.offer_1_50.offer_04;

/**
 * 二维数组中的查找
 * <p>
 *     在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *     请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * </p>
 * @Author: zhuzw
 * @Date: 2021-04-16 10:53
 * @Version: 1.0
 */
public class FindNumberIn2DArray04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int result = binarySearch(ints, target);
            if (result != -1) {
                return true;
            }
        }
        return false;
    }

    public int binarySearch(int[] arr, int searched) {

        return doBbinarySearch(arr, searched, 0, arr.length - 1);
    }

    public int doBbinarySearch(int[] arr, int searched, int start, int end) {
        if (start > end) {
            return -1;
        }
        if (arr[start] > searched || arr[end] < searched ) {
            return -1;
        }
        int mid = (start + end) / 2;
        int midValue = arr[mid];
        if (searched == midValue) {
            return mid;
        }else if (searched > midValue) {
            return doBbinarySearch(arr, searched, mid + 1, end);
        }else {
            return doBbinarySearch(arr, searched, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        FindNumberIn2DArray04 findNumberIn2DArray04 = new FindNumberIn2DArray04();
        int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//        int[][] arr = {{-5}};

        boolean numberIn2DArray = findNumberIn2DArray04.findNumberIn2DArray2(arr, 20);
        System.out.println(numberIn2DArray);
    }

    /**
     * 从右上角开始，相当于二分查找数
     *
     * 左边数小于当前数(cell--)，下变数大于当前数(row++)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = 0;
        int cell = matrix[0].length - 1;
        while (row < matrix.length && cell >= 0) {
            if (target > matrix[row][cell]) {
                row ++;
            }else if (target < matrix[row][cell]) {
                cell --;
            } else {
                return true;
            }
        }
        return false;
    }
}
