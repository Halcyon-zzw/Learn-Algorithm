package hot.双指针;

/**
 * 42. 接雨水
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * @author zhuzhiwei
 * @date 2023/12/7 16:47
 */
public class Hot_42_接雨水 {
    /**
     * 递归
     *
     * 找出最长的两个柱子，计算雨量
     * 递归前柱子r前部分
     * 递归前柱子l后部分
     */
    private int trapSum = 0;

    public int trap(int[] height) {
        return trap1(height);
    }

    public int trap1(int[] height) {
        trap1(height, 0, height.length - 1);
        return trapSum;
    }

    public void trap1(int[] height, int l, int r) {
        if (r - l <= 1) {
            return;
        }
        int max = 0, secondMax = 0, lIndex = 0, rIndex = 0;
        for (int i = l; i <= r; i++) {
            if (height[i] >= max) {
                secondMax = max;
                max = height[i];
                rIndex = lIndex;
                lIndex = i;
            } else if (height[i] >= secondMax) {
                secondMax = height[i];
                rIndex = i;
            }
        }
        if (lIndex > rIndex) {
            int tmp = lIndex;
            lIndex = rIndex;
            rIndex = tmp;
        }
        trapSum += calArea(height, lIndex, rIndex, secondMax);
        trap1(height, l, lIndex);
        trap1(height, rIndex, r);
    }

    private int calArea(int[] height, int lIndex, int rIndex, int limit) {
        if (rIndex - lIndex <= 1) {
            return 0;
        }
        int area = 0;
        for (int i = lIndex + 1; i < rIndex; i++) {
            area += (limit - height[i]);
        }
        return area;
    }

    /**
     * 双指针
     * 两端各一个指针，
     * 双指针每次向内收缩短板至下一次比当前短板长的位置，
     * 计算双指针和底板构成的容器盛水量（底板：上一次的短板）
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int l = 0, r = height.length -1;
        //底板
        int bottomBoard = 0;
        int sumArea = 0;
        while (l < r) {
            if (height[l] == 0) {
                l++;
            }
            if (height[r] == 0) {
                r--;
            }
            //短板
            int shortBoard = Math.min(height[l], height[r]);
            sumArea += calArea(height, bottomBoard, shortBoard, l, r);
            int lCurVal = height[l], rCurVal = height[r];
            if (lCurVal < rCurVal) {
                while (l < r && height[l] <= lCurVal) {
                    l++;
                }
            } else {
                while (l < r && height[r] <= rCurVal) {
                    r--;
                }
            }
            bottomBoard = shortBoard;
        }
        return sumArea;
    }

    /**
     * 计算面积
     * @param height 数组
     * @param bottomBoard 底板
     * @param shortBoard 短板
     * @param l 左挡板位置
     * @param r 右挡板位置
     * @return 面积值
     */
    private int calArea(int[] height, int bottomBoard, int shortBoard, int l, int r) {
        int sum = 0;
        for (int i = l + 1; i < r; i++) {
            if (height[i] < shortBoard) {
                sum += (shortBoard - Math.max(height[i], bottomBoard));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {6, 4,  2,  0,  3,  2,  0,  3,  1,  4,  5,  3,  2,  7,  5,  3,  0,  1,  2,  1,  3,  4,  6,  8,  1,  3};
//        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = new Hot_42_接雨水().trap(height);
        int trap2 = new Hot_42_接雨水().trap2(height);
        System.out.println(trap + " " + trap2 + " " + (trap == trap2));
    }
}
