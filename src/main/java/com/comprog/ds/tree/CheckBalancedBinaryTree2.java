package com.comprog.ds.tree;

public class CheckBalancedBinaryTree2 {
	public boolean isBalanced(TreeNode root) {
		int height = checkandGetBalanced(root);
		if (height == -1)
			return false;
		return true;
	}

	private int checkandGetBalanced(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = checkandGetBalanced(root.left);
		if (left == -1)
			return -1;
		int right = checkandGetBalanced(root.right);

		if (right == -1 || Math.abs(left - right) > 1) {
			return -1;
		} else {
			return 1 + Math.max(left, right);
		}
	}
}
