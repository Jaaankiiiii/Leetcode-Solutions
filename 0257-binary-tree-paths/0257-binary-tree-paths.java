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
    void helper(TreeNode root, String str, List<String> ans){
        if(root==null) return;
        //last node
        if(root.left==null && root.right==null){ 
            //append it into array
            ans.add(str+root.val);
            return;
        }
        //if not last node
        
        helper(root.left,str+root.val+"->",ans);
        helper(root.right,str+root.val+"->",ans);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root,"",ans);
        return ans;
    }
}