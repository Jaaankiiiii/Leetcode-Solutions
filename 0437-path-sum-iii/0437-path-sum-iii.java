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
    public int helper(TreeNode root, long target){
        if(root==null) return 0;
        int count = 0;
        target -= root.val;
        if(target==0) count++;
        count += helper(root.left,target);
        count += helper(root.right,target);
        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int count = 0;
        return helper(root, targetSum) + pathSum(root.left,targetSum) + pathSum(root.right, targetSum);
        
    }
}