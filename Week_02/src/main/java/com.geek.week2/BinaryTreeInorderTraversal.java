package com.geek.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

  /**
   * 二叉树中序遍历-递归
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversalByRecursion(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    reversal(root, result);
    return result;
  }

  /**
   * 二叉树中序遍历-迭代
   *
   * @param root
   * @return
   */
  public List<Integer> inorderTraversalByIteration(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Stack<TreeNode> stack = new Stack<>();
    Map<TreeNode, Boolean> map = new HashMap<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      if ((root.left == null && root.right == null) || map.containsKey(root)) {
        result.add(root.val);
        continue;
      }

      if (root.right != null) {
        stack.push(root.right);
      }

      map.put(root, true);
      stack.push(root);
      if (root.left != null) {
        stack.push(root.left);
      }
    }

    return result;
  }

  private void reversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    reversal(root.left, list);
    list.add(root.val);
    reversal(root.right, list);
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
