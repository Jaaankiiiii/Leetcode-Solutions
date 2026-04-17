class Solution {
    public int[] asteroidCollision(int[] a) {
        Stack<Integer> st = new Stack<>();
        int n = a.length;
        for(int i =0; i<n; i++){
            boolean destroyed = false;
            while(st.size()>0 && st.peek()>0 && a[i]<0){
                if(Math.abs(st.peek())<Math.abs(a[i])) st.pop();
                else if( Math.abs(st.peek())>Math.abs(a[i])){
                    destroyed=true;
                    break;
                }else{
                    st.pop();
                    destroyed=true;
                    break;
                }
            }
            if(!destroyed) st.push(a[i]);
        }
        int[] ans = new int[st.size()];
        int i=st.size()-1;
        while(st.size()>0){
            ans[i--]=st.pop();
        }
        return ans;
    }
}