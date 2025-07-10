package normal.normal_401.impl;

import normal.normal_401.BinaryWatch;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举比特
 *
 * 总共有10个灯，2^10 = 1024，高四位表示小时，低四位表示分钟。
 * 枚举0-1024中比特数
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 10:34
 * @Version: 1.0
 */
public class BinaryWatchByEnumerateBitImpl implements BinaryWatch {
    @Override
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        int mark = (int)Math.pow(2, 6) - 1;
        for (int i = 0; i < 1024; i++) {
            int minute = i & mark, hour = i >> 6;
            if (hour >= 12 || minute >= 60) {
                continue;
            }
            if (Integer.bitCount(i) == turnedOn) {
                result.add(hour + ":" + (minute >= 10 ? minute : "0" + minute));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TestUtils.test(BinaryWatchByEnumerateBitImpl.class, 9);
    }
}
