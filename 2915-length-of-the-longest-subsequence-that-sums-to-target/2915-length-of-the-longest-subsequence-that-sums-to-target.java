class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        int ans = helper(nums,0,target,dp);
        return ans<0 ? -1 : ans;
    }
    public int helper(List<Integer> arr, int idx, int target, int[][] dp){
        if(target==0) {
            return 0;
        }
        if(idx>=arr.size()){
            return Integer.MIN_VALUE;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int skip = helper(arr,idx+1,target,dp);
        int pick = Integer.MIN_VALUE;
        if(arr.get(idx)<=target){
            pick = 1 + helper(arr, idx + 1, target - arr.get(idx),dp);
        }
        return dp[idx][target] = Math.max(skip,pick);

    }
}