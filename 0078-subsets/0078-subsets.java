class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        helper(nums,0,ans,a);
        return ans;
    }
    void helper(int[] nums,int idx,List<List<Integer>> ans,List<Integer> a  ){
        if(idx==nums.length){
            ans.add(new ArrayList<>(a));
            return;
        }
        helper(nums,idx+1,ans,a);
        a.add(nums[idx]);
        helper(nums,idx+1,ans,a);
        a.remove(a.size()-1);
    }
}