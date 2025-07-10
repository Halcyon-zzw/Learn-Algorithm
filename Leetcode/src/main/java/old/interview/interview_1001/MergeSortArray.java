package interview.interview_1001;

/**
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 *
 * @Author: zhuzw
 * @Date: 2021-05-31 15:40
 * @Version: 1.0
 */
public interface MergeSortArray {
    void merge(int[] A, int m, int[] B, int n);
}
