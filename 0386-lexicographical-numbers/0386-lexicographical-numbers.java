class Solution {
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1; i<=9; i++){
            solve(i,n,ans);
        }
        return ans;
    }
    public void solve(int i , int n, ArrayList<Integer> ans){
        if(i>n) return;
        ans.add(i);
        for(int j=0; j<=9; j++){
            int num = i*10+j;
            if(num > n) return; 
            solve(num,n, ans);
        }
    }
}