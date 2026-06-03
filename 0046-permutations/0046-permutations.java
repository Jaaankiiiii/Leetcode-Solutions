class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for(int i=0;i<nums.length;i++) visited[i]=false;
        helper(nums,-1,ans,a,visited);
        return ans;
    }
    public void helper(int[] nums , int idx, List<List<Integer>> ans, List<Integer> a, boolean[] visited ){
        if(idx > nums.length) return;
        if(a.size()==nums.length){
            ans.add(new ArrayList<>(a));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                a.add(nums[i]);
                visited[i] = true;
                helper(nums,i,ans,a,visited);
                a.remove(a.size()-1);
                visited[i] = false;
            }
        }
    }
}