class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for(int i=0; i<nums.length; i++) visited[i]=false;
        helper(nums,-1,a,ans,visited);
        return ans;
    }
    void helper(int[] nums, int idx,List<Integer> a ,List<List<Integer>> ans ,boolean[] visited ){
        if(idx==nums.length) return;
        if(a.size()==nums.length){
            ans.add(new ArrayList<>(a));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i]==nums[i-1] && !visited[i-1]) continue;
            if(!visited[i]){
                a.add(nums[i]);
                visited[i]=true;
                helper(nums,i,a,ans,visited);
                a.remove(a.size()-1);
                visited[i] = false;
            }
        }  
    }
}