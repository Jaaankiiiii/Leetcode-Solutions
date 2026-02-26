class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];
        helper(nums, isVisited,new ArrayList<>(),ans);
        return ans;
    }
    public void helper(int[] nums, boolean[] isVisited,List<Integer> v,List<List<Integer>> ans){
        if(v.size()==nums.length){
            ans.add(new ArrayList<>(v));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                v.add(nums[i]);
                helper(nums,isVisited,v,ans);
                v.remove(v.size() - 1);
                isVisited[i] = false;
            }
        }
    }
}