class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        subset(nums,a,ans,0);
        return ans;
    }
    public void subset(int[] nums, ArrayList<Integer> a, List<List<Integer>> ans, int idx){
        if(idx==nums.length){
            ans.add(new ArrayList<>(a));
            return;
        }
        int ele = nums[idx];
        subset(nums,a,ans,idx+1);
        a.add(ele);
        subset(nums,a,ans,idx+1);
        a.remove(a.size()-1);
    }
}