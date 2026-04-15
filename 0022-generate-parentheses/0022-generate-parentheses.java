class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(0,0,ans, "", n);
        return ans;
    }
    public void generate(int open, int close, List<String> ans, String str, int n){
        if(open == close && close == n){
            ans.add(str);
            return;
        }
        if(open<n) generate(open+1, close, ans, str+"(" ,n);
        if(close<open) generate(open, close+1, ans, str+")",n);
        // str.remove(str.length()-1);
    }
}