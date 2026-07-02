class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int x : nums) sum+=x;

        int[][]dp = new int[n][2*sum+1];
        for(int[] row: dp) Arrays.fill(row,-1);

        return totalWays(nums,0,0,target, dp,sum);

    }
    public int totalWays(int[] nums, int idx,int res, int target, int[][] dp, int sum){
        //if(target==0) return 1; // will not write here cause i dont want to return the ans in between when target is found -> qn mentioned we have to use all elements ( means go till the end );
        if(idx >= nums.length){
            if(res==target) return 1;
            else return 0;
        }
        if(dp[idx][res+sum]!=-1) return dp[idx][res+sum];
        int skip = totalWays(nums,idx+1,res-nums[idx],target,dp,sum);
        int pick = totalWays(nums,idx+1,res+nums[idx],target,dp,sum);
        return dp[idx][res+sum]=skip+pick;
    }
}