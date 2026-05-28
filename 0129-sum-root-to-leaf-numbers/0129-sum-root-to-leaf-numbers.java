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
    public int sumNumbers(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root,"", ans);
        int sum=0;
        for(int i=0; i<ans.size(); i++){
            sum+=Integer.parseInt(ans.get(i));
        }
        return sum;
    }
    public void helper(TreeNode root, String path, List<String> ans){
        if(root==null) return;
        path+=root.val;
        if(root.left==null && root.right==null){
            ans.add(path);
        }
        helper(root.left,path,ans);
        helper(root.right,path,ans);
    }
}