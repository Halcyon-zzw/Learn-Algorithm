package old.offer.offer_66;

/**
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 *
 *
 * @Author: zhuzw
 * @Date: 2021-04-27 16:51
 * @Version: 1.0
 */
public interface ConstructArr {
    int[] constructArr(int[] a);
}
