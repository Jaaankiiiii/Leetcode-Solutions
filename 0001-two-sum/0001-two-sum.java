class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> maps = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            int x=target-nums[i];
            if(maps.containsKey(x)){
                ans[0] = maps.get(x);
                ans[1] = i;
            }
            else{
                maps.put(nums[i],i);
            }
        }
        return ans;
    }
}