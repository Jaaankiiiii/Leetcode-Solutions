class Solution {
    public boolean isSubsequence(String s, String t) {
        int j =0;
        for(int i=0; i<s.length(); i++){
            boolean found = false;
            for(int k=j; k<t.length(); k++){
                if(s.charAt(i)==t.charAt(k)){
                    found=true;
                    j=k+1;
                    break;
                }
            }
            if(found==false) return false;
        }
        return true;
    }
}