package com.cjh.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈哈哈
 * @date 2022年12月26日 21:17
 * @description
 * @Data
 */
public class _257_二叉树的所有路径 {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        helper(root, "");
        return result;
    }

    private void helper(TreeNode root, String path) {
        if (root != null) {
            // 同样的递归调用，如果直接用String进行拼接的话就会在此过程生成多String对象
            // 如果用StringBuilder的话就可以少产生很多对象，从而提高效率
            StringBuilder builder = new StringBuilder(path);
            builder.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                result.add(builder.toString());
            } else {
                builder.append("->");
                helper(root.left, builder.toString());
                helper(root.right, builder.toString());
            }
        }
    }

    // 使用String做拼接的反面教材，比用StringBuilder的慢了十倍
    // List<String> result = new ArrayList<>();
    //
    // public List<String> binaryTreePaths(TreeNode root) {
    //     if (root == null) return result;
    //     helper(root, root.val + "->");
    //     return result;
    // }
    //
    // private void helper(TreeNode root, String path) {
    //     if (root.left == null && root.right == null) {
    //         result.add(path.substring(0, path.length() - 2));
    //         return;
    //     }
    //     if (root.left != null) helper(root.left, path + root.left.val + "->");
    //     if (root.right != null) helper(root.right, path + root.right.val + "->");
    // }
}
