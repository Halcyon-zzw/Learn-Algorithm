package hot.链表;

import mode.ListNode;
import mode.TwoWayListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value)
 *      如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。
 *      如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * @author zhuzhiwei
 * @date 2023/11/28 15:02
 */
public class Hot_146_LRU缓存 {

}

class LRUCache {
    /**
     * 缓存值 -> 前置节点
     */
    private final Map<Integer, TwoWayListNode> map;
    private final TwoWayListNode head = new TwoWayListNode(0);
    private final TwoWayListNode tail = new TwoWayListNode(-1);
    private final int capacity;
    private int curCapacity = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.pre = head;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(1, 1);
        lruCache.put(2, 3);
        lruCache.put(4, 1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            //移动位置到头部
            TwoWayListNode p = map.get(key);
            p.next.pre = p.pre;
            p.pre.next = p.next;

            pushNodeInHead(p);

            return p.val;
        }
        return -1;
    }

    /**
     * 将节点插入到头部
     * @param p
     */
    private void pushNodeInHead(TwoWayListNode p) {
        TwoWayListNode hp = head.next;
        head.next = p;
        p.pre = head;
        p.next = hp;
        hp.pre = p;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //更新值
            TwoWayListNode p = map.get(key);
            p.val = value;
            //移动位置到头部
            p.next.pre = p.pre;
            p.pre.next = p.next;
            pushNodeInHead(p);
        } else {
            //插入到头部并保存到map中
            TwoWayListNode cache = new TwoWayListNode(key, value);
            pushNodeInHead(cache);

            map.put(key, cache);
            curCapacity++;
            //超过容量
            if (curCapacity > capacity) {
                //删除尾部元素
                //怎么删除map
                TwoWayListNode last = tail.pre;
                map.remove(last.key);

                TwoWayListNode tp = tail.pre.pre;
                tp.next = tail;
                tail.pre = tp;

            }
        }
    }
}