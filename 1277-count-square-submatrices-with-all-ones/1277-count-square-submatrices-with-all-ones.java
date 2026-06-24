class Solution {
    public int min(int a , int b , int c){
        if(a<b && a<c) return a;
        if(b<c) return b;
        return c;
    }
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int sum=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || matrix[i][j]==0) dp[i][j]=matrix[i][j];
                else{
                    dp[i][j]=matrix[i][j] + min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
                }
                System.out.print(dp[i][j] + " ");
            sum += dp[i][j];
            }
        System.out.println();
        }
        return sum;
    }
}