/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean exists(TreeNode root, TreeNode target){
        if(root==null) return false;
        if(root==target) return true;
        return exists(root.left, target) || exists(root.right,target); 
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(exists(root.left,p) && exists(root.left,q)){
            return lowestCommonAncestor(root.left, p,q);
        }
        if(exists(root.right,p) && exists(root.right,q)){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }
}