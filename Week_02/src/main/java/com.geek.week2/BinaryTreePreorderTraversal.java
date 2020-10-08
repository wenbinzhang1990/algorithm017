package com.geek.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {

  /**
   * 二叉树前序遍历-递归
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversalByRecursion(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    reversal(root, list);
    return list;
  }

  /**
   * 二叉树前序遍历-迭代
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversalByIteration(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if (root == null) {
      return list;
    }

    Stack<TreeNode> stack = new Stack();
    stack.push(root);
    while (!stack.isEmpty()) {
      root = stack.pop();
      list.add(root.val);
      if (root.right != null) {
        stack.push(root.right);
      }

      if (root.left != null) {
        stack.push(root.left);
      }
    }

    return list;
  }

  /**
   * 二叉树前序遍历-迭代（与中后序保持一致）
   *
   * @param root
   * @return
   */
  public List<Integer> preorderTraversalByIterationUnion(
      TreeNode root) {
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

      if (root.left != null) {
        stack.push(root.left);
      }

      map.put(root, true);
      result.add(root.val);
    }

    return result;
  }

  private void reversal(TreeNode treeNode, List<Integer> list) {
    if (treeNode == null) {
      return;
    }

    list.add(treeNode.val);
    reversal(treeNode.left, list);
    reversal(treeNode.right, list);
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
