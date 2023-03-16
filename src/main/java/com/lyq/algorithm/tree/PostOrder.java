package com.lyq.algorithm.tree;

/**
 * @author yuanqiang.liao
 * @description TODO
 * @createTime 2023-03-14 17:05:00
 */
public class PostOrder {
    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());
        System.out.println(root.getValue());
    }

    public static void postOrderWhile(TreeNode root) {
        //
    }
}
