package hot.双指针;

/**
 * 11. 盛最多水的容器
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * @author zhuzhiwei
 * @date 2023/12/7 11:23
 */
public class Hot_11_盛最多水的容器 {

    /**
     * 前提1：盛水量由较短的垂线决定
     *
     * l = 0; r = n - 1;
     * 每次向内移动较短指针
     * 计算盛水量
     * if 当前垂线小于历史最大(最短垂线不变，但宽度变小)
     *      继续移动
     *
     *
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(area, maxArea);
            if (height[l] < height[r]) {
                l++;
                while (height[l] < height[l - 1] && l < r) {
                    l++;
                }
            } else {
                r--;
                while (height[r] < height[r + 1] && l < r) {
                    r--;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = new Hot_11_盛最多水的容器().maxArea(height);
        System.out.println(maxArea);
    }
}
