class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x : nums) sum+=x;
        if(sum%2 != 0) return false;
        int[][] dp = new int[nums.length][sum/2 + 1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(nums,0,sum/2,dp);
    }
    public boolean helper(int[] nums, int idx, int target, int[][] dp){
        if(target==0) return true;
        if(idx>=nums.length) return false;
        if(dp[idx][target]!=-1) return (dp[idx][target]==1);
        boolean ans = false;
        if(nums[idx] > target) ans=helper(nums,idx+1, target,dp);
        else{
            ans=helper(nums,idx+1, target,dp) || helper(nums,idx+1, target-nums[idx],dp);
        }
        dp[idx][target] = ans? 1: 0;
        return ans;
    }
}