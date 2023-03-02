package com.lyq.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanqiang.liao
 * @description 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * @createTime 2023-03-01 18:15:00
 */
public class LRUCache {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1);
        lRUCache.put(1, 1);
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        lRUCache.get(1);
        lRUCache.get(2);

    }

    int capacity;
    int size;
    Map<Integer, DoubleEndList> cache = new HashMap<>();
    DoubleEndList head, tail;


    /**
     * 使用伪头，伪尾，后续的删除、添加不需要再判断是否为空。
     * @param capacity
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DoubleEndList();
        tail = new DoubleEndList();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DoubleEndList node = cache.get(key);
            removeNode(node);
            add2Header(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        DoubleEndList node = cache.get(key);
        if (node != null) {
            node.value = value;
            removeNode(node);
            add2Header(node);
        } else {
            node = new DoubleEndList(key, value);
            cache.put(key, node);
            add2Header(node);
            size++;
            if (size > capacity) {
                DoubleEndList tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

    private DoubleEndList removeTail() {
        DoubleEndList node = tail.prev;
        removeNode(node);
        return node;
    }

    private void add2Header(DoubleEndList node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DoubleEndList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static class DoubleEndList {
        int key;
        int value;
        DoubleEndList prev;
        DoubleEndList next;

        DoubleEndList() {
        }

        DoubleEndList(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
}
