class Solution {
    public int bestClosingTime(String customer) {
        int n = customer.length();
        int[] yes = new int[n+1];
        int[] no = new int[n+1];
        for(int i=n-1; i>=0; i--){
            if(customer.charAt(i)=='Y') yes[i] = yes[i+1] + 1;
            else yes[i] = yes[i+1];
        }
         
        for(int i=1; i<n+1; i++){
            if(customer.charAt(i-1)=='N') no[i] = no[i-1]+1;
            else no[i]=no[i-1];
        }
        int minIdx = 0;
        for(int i=1; i<n+1; i++){
            if((yes[i]+no[i]) < (yes[minIdx]+no[minIdx])) minIdx=i;
        }
        return minIdx;
    }
}