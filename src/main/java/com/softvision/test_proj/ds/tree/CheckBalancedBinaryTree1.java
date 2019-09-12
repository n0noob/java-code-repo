package com.softvision.test_proj.ds.tree;

public class CheckBalancedBinaryTree1 {
    public boolean isBalanced(TreeNode root) {
        
        if(root == null) {
            return true;
        }
        
        int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
        
        if(diff > 1)
            return false;
        
        return isBalanced(root.left) && isBalanced(root.right);
        
    }
    
    private int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        
        return 1+Math.max(getHeight(root.left), getHeight(root.right));
        
    }
}