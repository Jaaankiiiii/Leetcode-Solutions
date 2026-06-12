class Solution {
    static int[] d;
    public int fibo(int n) {
        if(n<=1) return n;
        if(d[n]!=0) return d[n];
        int ans = fibo(n-1)+fibo(n-2);
        d[n] = ans;
        return ans;
    }
    public int fib(int n){
        d=new int[n+1];
        return fibo(n);
    }
}