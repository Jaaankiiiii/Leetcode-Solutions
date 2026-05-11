/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    void invert(TreeNode root){
        if(root==null) return;
        if(root.left==null && root.right==null) return;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = r;
        root.right = l;
        invert(root.left);
        invert(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        invert(root);
        return root;
    }
} 