package normal.normal_401.impl;

import normal.normal_401.BinaryWatch;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 枚举时分
 *
 * 枚举0：00-12:59，计算其二进制比特的数量
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 10:26
 * @Version: 1.0
 */
public class BinaryWatchByEnumerateTimeImpl implements BinaryWatch {
    @Override
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= 11; i++) {
            for (int j = 0; j <= 59; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                    result.add(i + ":" + (j >= 10 ? j : "0" + j));
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TestUtils.test(BinaryWatchByEnumerateTimeImpl.class, 9);
    }
}
