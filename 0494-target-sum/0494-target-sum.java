class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return totalWays(nums,0,target);
    }
    public int totalWays(int[] nums, int idx, int target){
        //if(target==0) return 1; // will not write here cause i dont want to return the ans in between when target is found -> qn mentioned we have to use all elements ( means go till the end );
        if(idx >= nums.length){
            if(target==0) return 1;
            else return 0;
        }
        int skip = totalWays(nums,idx+1,target-nums[idx]);
        int pick = totalWays(nums,idx+1,target+nums[idx]);
        return skip+pick;
    }
}