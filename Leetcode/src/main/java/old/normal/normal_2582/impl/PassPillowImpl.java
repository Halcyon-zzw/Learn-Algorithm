package normal.normal_2582.impl;

import normal.normal_2582.PassPillow;

/**
 *
 *
 * @author zhuzhiwei
 * @date 2023/9/26 14:44
 */
public class PassPillowImpl implements PassPillow {
    @Override
    public int passThePillow(int n, int time) {

        int halfCycle = n - 1;
        //一个周期值
        int cycle = halfCycle * 2;
        int mod = time % cycle;
        if (mod < halfCycle) {
            return mod + 1;
        } else {
            return n - (mod % cycle);
        }
    }

    /**
     * 解法二，代码优化
     * @param n
     * @param time
     * @return
     */
    public int passThePillow2(int n, int time) {
        //确定方向
        int k = time / (n - 1);
        //确定剩余的量
        int mod = time % (n - 1);

        if (k % 2 == 0) {
            return mod + 1;
        }
        return n - mod;
    }
}
