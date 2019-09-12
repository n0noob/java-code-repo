package com.softvision.test_proj.ds.tree;

public class Driver {
	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(4);
		bst.insert(2);
		bst.insert(6);
		bst.insert(10);
		bst.insert(11);
		//bst.insert(15);
		bst.preOrderTraversal(bst.getRoot());
		System.out.println("\n");
		bst.findMin();
		
		System.out.println("Max depth : " + bst.findDepth(bst.getRoot()));
	}
}
