package offer.offer_1_50.offer_45.impl;

import offer.offer_1_50.offer_45.MinNumber;

/**
 * 排序，
 * x + y > y + x，则 x > y
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * @Author: zhuzw
 * @Date: 2021-04-23 10:31
 * @Version: 1.0
 */
public class MinNumberImpl implements MinNumber {
    @Override
    public String minNumber(int[] nums) {
        //排序
        nums = sort(nums);
        String result = "";
        for (int num : nums) {
            result += num;
        }
        return result;
    }

    private int[] sort(int[] nums) {
        //趟数
        for (int i = 0; i < nums.length - 1; i++) {
            //比较
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (compare(nums[j], nums[j + 1]) > 0) {
                    //交换
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
            //无需去掉前导 0
//        if (nums[0] == 0) {
//            //保证首位不为0
//            int i = 0;
//            //找到非0下标
//            while (i < nums.length && nums[i] == 0) {
//                i++;
//            }
//            //排除全0情况
//            if (i < nums.length) {
//                nums[0] = nums[i];
//                nums[i] = 0;
//            }
//        }
        return nums;
    }

    private int compare(int a, int b) {
        String val1 = a + "" + b;
        String val2 = b + "" + a;
        return val1.compareTo(val2);

    }
}
