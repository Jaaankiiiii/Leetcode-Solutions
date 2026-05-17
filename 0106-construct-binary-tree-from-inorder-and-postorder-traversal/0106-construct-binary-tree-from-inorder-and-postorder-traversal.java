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
    int postIdx = 0;
    HashMap<Integer, Integer> inorderIdx = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++){
            inorderIdx.put(inorder[i],i);
        }
        int i=0,j=postorder.length-1;
        while(i<j){
            int temp = postorder[i];
            postorder[i] = postorder[j];
            postorder[j] = temp;
            i++;
            j--;
        }
        return postIn(postorder, 0, postorder.length-1);
    }
    TreeNode postIn(int[] postorder, int left, int right){
        if(left > right) return null;
        TreeNode root = new TreeNode(postorder[postIdx++]);
        int idx = inorderIdx.get(root.val);
        root.right = postIn(postorder,idx+1, right);
        root.left=postIn(postorder,left,idx-1);
        return root;
    }
}