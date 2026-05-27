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
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIdx ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for(int i=0; i<n; i++){
            map.put(inorder[i],i);
        }
        postIdx = n-1;
        return helper(inorder, postorder,0,n-1);
    }
    TreeNode helper(int[] inorder, int[] postorder, int left, int right){
        if(left>right) return null;
        TreeNode root = new TreeNode(postorder[postIdx--]);
        int idx = map.get(root.val);
        root.right = helper(inorder,postorder,idx+1,right);
        root.left = helper(inorder, postorder, left, idx-1);
        return root;
    }
}