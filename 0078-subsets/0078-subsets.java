class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i =0; i<Math.pow(2,nums.length); i++){
            List<Integer> a = new ArrayList<>();
            for(int j=0; j<nums.length;j++){
                if((i>>j)%2==1) a.add(nums[j]);
            }
            ans.add(a);
        }
        return ans;
    }
}