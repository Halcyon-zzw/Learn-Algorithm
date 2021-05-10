package normal.normal_1723;

/**
 * 1723. 完成所有工作的最短时间
 *
 * <p>
 *     给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间。
 *
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 *
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 *
 * </p>
 *
 * @Author: zhuzw
 * @Date: 2021-05-08 11:17
 * @Version: 1.0
 */
public interface MinimumTimeRequired {
    int minimumTimeRequired(int[] jobs, int k);
}