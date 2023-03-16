package com.lyq.algorithm.tree;

import java.util.LinkedList;

/**
 * @author yuanqiang.liao
 * @description TODO
 * @createTime 2023-03-14 17:31:00
 */
public class Dfs {
    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.getValue());
            if (node.getRight() != null) {
                stack.push(node.getRight());
            }
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }

    }
}
