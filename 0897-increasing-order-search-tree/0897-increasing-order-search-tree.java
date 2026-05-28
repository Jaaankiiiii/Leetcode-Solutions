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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> in = new ArrayList<>();
        inorder(root,in);
        TreeNode r = new TreeNode(in.get(0));
        TreeNode temp = r;
        for(int i=1; i<in.size(); i++){
            TreeNode t = new TreeNode(in.get(i));
            temp.right=t;
            temp.left = null;
            temp=temp.right;
        }
        temp.right=null;
        return r;
    }
    void inorder(TreeNode root, ArrayList<Integer> ans){
        if(root==null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
}