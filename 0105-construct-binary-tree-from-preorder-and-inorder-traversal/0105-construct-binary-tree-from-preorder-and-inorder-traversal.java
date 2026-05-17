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
    int preIndx = 0;
    HashMap<Integer,Integer> inorderIdx = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            inorderIdx.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
    }
    TreeNode helper(int[] preorder, int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(preorder[preIndx++]);
        int idx = inorderIdx.get(root.val);
        root.left = helper(preorder,left, idx-1);
        root.right = helper(preorder,idx+1, right);
        return root;
    }
}