class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }
    public void helper(int[] nums, int idx, List<List<Integer>> ans){
        if(idx==nums.length-1){
            List<Integer> v = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                v.add(nums[i]);
            }
            ans.add(v);
            return;
        }
        for(int i=idx; i<nums.length; i++){
            swap(i,idx,nums);
            helper(nums,idx+1,ans);
            swap(i,idx,nums);
        }
    }
    public void swap(int i, int idx, int[] nums){
        int temp = nums[i];
        nums[i] = nums[idx];
        nums[idx] = temp;
    }
}