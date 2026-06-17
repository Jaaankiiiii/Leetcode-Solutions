class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j]=-1;
            }
        }
        return helper(0,0,m,n,dp);
    }
    public int  helper(int sr, int sc, int er, int ec,int[][] dp){
        if(sr>=er || sc>=ec) return 0;
        if(sr==er-1 && sc==ec-1) return 1;
        if(dp[sr][sc] !=-1) return dp[sr][sc];
        return dp[sr][sc] = helper(sr+1,sc,er,ec,dp) + helper(sr,sc+1,er,ec,dp);
    }
}