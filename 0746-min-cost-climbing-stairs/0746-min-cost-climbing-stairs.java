class Solution {
    // int minCost=Integer.MAX_VALUE;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return Math.min(helper(cost,n-1,dp),helper(cost,n-2,dp));
    }
    public int helper(int[] cost, int idx, int[] dp){
        if(idx==0 || idx==1) return cost[idx];
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]=cost[idx]+ Math.min(helper(cost, idx-1,dp),helper(cost, idx-2,dp));
    }
}