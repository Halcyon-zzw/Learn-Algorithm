package normal.normal_401;

import java.util.List;

/**
 * 二进制手表
 * <p>
 *     二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 *     每个 LED 代表一个 0 或 1，最低位在右侧。
 *
 *     给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。
 *     可以 按任意顺序 返回答案。
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-06-21 10:24
 * @Version: 1.0
 */
public interface BinaryWatch {
    List<String> readBinaryWatch(int turnedOn);
}
