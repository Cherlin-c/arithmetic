package com.scl.leetbook;


import com.scl.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 从上到下打印二叉树
 *
 * @author : scl
 * @date :  2022/9/29
 */
public class Offer_32_1 {
    public static void main(String[] args) {
        // 初始化节点
        // 根节点 root
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(22);
        TreeNode n6 = new TreeNode(25);

        // 构建引用指向
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        System.out.println("levelOrder(n1) = " + Arrays.toString(levelOrder(n1)));
    }

    /*
    从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
    例如:
    给定二叉树:[3,9,20,1,null,22,25],
        3
       / \
      9  20
     /  /  \
    1  22  25
    返回：
    [3,9,20,15,7]
     */

    public static int[] levelOrder(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.removeFirst();
            result.add(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        int[] ints = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ints[i] = result.get(i);
        }
        return ints;
    }

}