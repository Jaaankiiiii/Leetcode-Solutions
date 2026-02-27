class Solution {
public:
    long long reverseNum(int x){
        long long r=0;
        long long reverse=0;
        while(x>0){
            r=x%10;
            x=x/10;
            reverse=reverse*10+r;
        }
        return reverse;
}
    bool isPalindrome(int x) {
        if(x<0) return false;
        int reverse = reverseNum(x);
        if(x==reverse) return true;
        else return false;
    }
};