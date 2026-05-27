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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return helper(nums,0,nums.length-1);
    }
    TreeNode helper(int[] num, int left, int right){
        if(left>right) return null;
        int mid = (right+left)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, left, mid-1);
        root.right = helper(num , mid+1, right);
        return root;
    }
}