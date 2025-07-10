package old.offer.offer_1_50.offer_21;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位于偶数前面
 * <p>
 *     输入一个整数数组，
 *     实现一个函数来调整该数组中数字的顺序，
 *     使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-04-20 11:17
 * @Version: 1.0
 */
public class Exchange21 {

    public int[] exchange2(int[] nums) {
        int[] result = new int[nums.length];
        int pre = 0;
        int post = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                result[post --] = nums[i];
            }else {
                result[pre++] = nums[i];
            }
        }
        return result;
    }

    public int[] exchange(int[] nums) {
        int pre = 0;
        int post = nums.length - 1;
        while(pre < post) {
            //找到左边第一个偶数
            while(pre < nums.length && nums[pre] % 2 != 0) {
                pre++;
            }
            if (pre == nums.length) {
                //全是奇数
                break;
            }
            //找到右边第一个奇数
            while( post >= 0 && nums[post] % 2 == 0) {
                post--;
            }
            if (post < 0) {
                //全是偶数
                break;
            }
            if (pre < post) {
                //下标不交叉才交换
                int t = nums[pre];
                nums[pre] = nums[post];
                nums[post] = t;
                //交换完，下标再次移动
                pre++;
                post--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Exchange21 exchange21 = new Exchange21();
        int[] nums = {1,11,14};
        nums = exchange21.exchange(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}
