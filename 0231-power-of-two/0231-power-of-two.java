class Solution {
    public boolean isPowerOfTwo(int n) {
        int countOfOne = 0;
        while(n>=1 && countOfOne<=2){
            int r = n%2;
            if(r==1) countOfOne++;
            n=n/2;
        }
        if(countOfOne==1) return true;
        return false;
    }
}