class Solution {
    // public int minPathSum(int[][] grid) {
    //     int er=grid.length;
    //     int ec=grid[0].length;
    //     return helper(grid,0,0,er,ec,0);
    // }
    // public int helper(int[][] grid, int sr, int sc, int er, int ec,int sum){
    //     if(sr>=er || sc >=ec) return Integer.MAX_VALUE;
    //     if(sr==er-1 && sc==ec-1){
    //         sum+=grid[sr][sc];
    //         return sum;
    //     }
    //     sum+=grid[sr][sc];
    //     return Math.min(helper(grid,sr+1,sc,er,ec,sum), helper(grid,sr,sc+1,er,ec,sum));
    // }
     public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;
                else if(i==0 && j!=0) dp[i][j]=grid[i][j]+dp[i][j-1];
                else if(j==0 && i!=0) dp[i][j]=grid[i][j]+dp[i-1][j];
                else dp[i][j]=grid[i][j]+ Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        for(int[] row : dp) System.out.println(Arrays.toString(row));
        return dp[m-1][n-1];
    }
}