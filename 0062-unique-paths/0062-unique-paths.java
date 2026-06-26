class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n];
        int count=0;
        Arrays.fill(dp[0],1);
        Arrays.fill(dp[1],1);
        for(int i=1; i<=m-1; i++){
            for(int j=1; j<n; j++){ 
                if(count%2==0){
                    dp[1][j] = dp[1][j-1] + dp[0][j];
                    dp[0][j] = dp[1][j];
                }else{
                    dp[0][j] = dp[0][j-1] + dp[1][j];
                    dp[1][j] = dp[0][j];
                }
            }
        }
        if(count%2==0) return dp[1][n-1];
        return dp[0][n-1];
    }
}