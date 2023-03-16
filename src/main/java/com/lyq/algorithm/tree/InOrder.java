package com.lyq.algorithm.tree;

import java.util.LinkedList;

/**
 * @author yuanqiang.liao
 * @description TODO
 * @createTime 2023-03-14 15:54:00
 */
public class InOrder {
    public static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.getLeft());
        System.out.println(root.getValue());
        inOrder(root.getRight());
    }

    public static void inOrderWhile(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                TreeNode node = stack.pop();
                System.out.println(node.getValue());
                current = node.getRight();
            }
        }
    }
}
