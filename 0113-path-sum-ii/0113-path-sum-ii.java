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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, targetSum,ans,new ArrayList<>());
        return ans;
    }
    void helper(TreeNode root, int targetSum, List<List<Integer>> ans ,List<Integer> a){
        if(root==null) return;
        a.add(root.val);
        targetSum-=root.val;
        if(targetSum==0 && root.left==null && root.right==null){
            ans.add(new ArrayList<>(a));
        }
        //a.add(root.val);
        helper(root.left,targetSum, ans,a );
        helper(root.right,targetSum, ans, a); 
        a.remove(a.size()-1);
    }
}