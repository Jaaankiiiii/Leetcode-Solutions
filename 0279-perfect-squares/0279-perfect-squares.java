class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++){
            if(isPerfectSquare(i)) dp[i]=1;
            else{
                int min=n;
                for(int j=1; j*j<=i; j++){
                    min=Math.min(min, dp[j*j]+dp[i-j*j]);
                }
                dp[i]=min;
            }

        }
        return dp[n];
    }
    public boolean isPerfectSquare(int i){
        int sq=(int)(Math.sqrt(i));
        return sq*sq==i;
    }
}