package com.scl.hot100.link;

import java.util.Stack;

/**
 * 1302. 层数最深叶子节点的和
 *
 * @author : scl
 * @date :  2022/8/17
 */
public class Mid1302 {

    /*
    给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
    输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
    输出：15
    输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    输出：19
    提示：
    树中节点数目在范围 [1, 104] 之间。
    1 <= Node.val <= 100
     */

    public static void main(String[] args) {

    }

    public int deepestLeavesSum(TreeNode root) {
        Stack<Integer> stack = new Stack<Integer>();
        TreeNode temp = root;
        while (temp.left == null
                && temp.right == null) {

        }
        return 0;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}