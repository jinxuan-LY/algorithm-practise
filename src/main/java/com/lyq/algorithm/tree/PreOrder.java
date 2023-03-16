package com.lyq.algorithm.tree;

import java.util.LinkedList;

/**
 * @author yuanqiang.liao
 * @description TODO
 * @createTime 2023-03-14 17:00:00
 */
public class PreOrder {
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.getValue());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

    public static void preOrderWhile(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                System.out.println(current.getValue());
                stack.push(current);
                current = current.getLeft();
            } else {
                TreeNode node = stack.pop();
                current = node.getRight();
            }
        }
    }
}
