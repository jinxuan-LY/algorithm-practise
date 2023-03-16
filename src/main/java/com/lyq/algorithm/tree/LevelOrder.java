package com.lyq.algorithm.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuanqiang.liao
 * @description TODO
 * @createTime 2023-03-14 17:25:00
 */
public class LevelOrder {
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.getValue());
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }
}
