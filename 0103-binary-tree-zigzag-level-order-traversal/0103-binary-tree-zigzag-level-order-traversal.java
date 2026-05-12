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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> a = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode r = q.poll();
                a.add(r.val);
                if(r.left!=null) q.offer(r.left);
                if(r.right!=null) q.offer(r.right);
            }
            if(!leftToRight){
                Collections.reverse(a);
            }
            ans.add(a);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}