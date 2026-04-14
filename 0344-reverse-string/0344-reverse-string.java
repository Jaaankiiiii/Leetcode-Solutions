class Solution {
    public void reverseString(char[] s) {
        recursion(s,0,s.length-1);
    }
    public void recursion(char[] s, int i, int j){
        if(i >= j) return;
        else{
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            recursion(s,i+1,j-1);
        }
    }
}