package com.comprog.ds.tree;

public class BST {
	private TreeNode root;
	
	public void insert(int data) {
		TreeNode newNode = new TreeNode(data);
		if(root == null) {
			root = newNode;
			return;
		}
		
		TreeNode temp = root;
		while(true) {
			//System.out.println("looping " + temp.data);
			if(data < temp.val) {
				if(temp.left == null) {
					temp.left = newNode;
					return;
				}
				temp = temp.left;
			}
			else {
				if(temp.right == null) {
					temp.right = newNode;
					return;
				}
				temp = temp.right;
			}
		}
	}
	
	public void search(int data) {
		TreeNode temp = root;
		
		while(temp != null) {
			if(data < temp.val)
				temp = temp.left;
			else if(data > temp.val)
				temp = temp.right;
			else {
				System.out.println("Data (" + data + ") found!");
				return;
			}
		}
		
		System.out.println("Node with data (" + data + ") not found");
		return;
	}
	
	public void findMin() {
		TreeNode temp = root;
		if(temp == null) {
			System.out.println("Empty BST !");
			return;
		}
		
		while(temp.left != null) {
			temp = temp.left;
		}
		
		System.out.println("Current minimum element : " + temp.val);
		return;
	}
	
	public void findMax() {
		TreeNode temp = root;
		if(temp == null) {
			System.out.println("Empty BST !");
			return;
		}
		
		while(temp.right != null) {
			temp = temp.right;
		}
		
		System.out.println("Current maximum element : " + temp.val);
		return;
	}

	public TreeNode getRoot() {
		return root;
	}
	
	public void preOrderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.val + " ");
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}
	
	public void inOrderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		
		inOrderTraversal(node.left);
		System.out.print(node.val + " ");
		inOrderTraversal(node.right);
	}
	
	public void postOrderTraversal(TreeNode node) {
		if(node == null) {
			return;
		}
		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		System.out.print(node.val + " ");
	}
	
	public int findDepth(TreeNode node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(findDepth(node.left), findDepth(node.right));
	}
}
