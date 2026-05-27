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
    HashMap<Integer,Integer> map = new HashMap<>();
    int preOrderIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // root of the tree;
        // TreeNode root = new TreeNode(preorder[0]);
        for(int i=0; i<n; i++){
            map.put(inorder[i],i);
            //element , index;
        }
        return helper(preorder,inorder,0,n-1);
        //int indx = map.get(root.val);
        //root.left;
        // root.left = helper(preorder, inorder, 0, indx-1);
        // root.right = helper(preorder,inorder, indx+1, n);

    }
    TreeNode helper(int[] preorder, int[] inorder, int left, int right){
        if(left>right) {
            return null;
        }
        // if(left==right){
        //     return new TreeNode(inorder[left]);
        // }
        TreeNode root = new TreeNode(preorder[preOrderIdx++]);
        int indx = map.get(root.val);
        root.left = helper(preorder, inorder, left, indx-1);
        root.right = helper(preorder,inorder, indx+1, right);
        return root;
    }
}