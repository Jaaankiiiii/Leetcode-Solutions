class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder("");
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) str.append(s.charAt(i));
        }
        
        return helper(str,0,str.length()-1);
    }
    public boolean helper(StringBuilder s, int i, int j){
        if(i>j) return true;
        char a = s.charAt(i);
        char b = s.charAt(j);
        if(a!=b) return false;
        else{
            return helper(s,i+1,j-1);
        }
    }

}