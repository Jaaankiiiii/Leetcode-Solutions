class Solution {
    public int reverseBits(int n) {
        int[] arr=new int[32];
        int i=31;
        while(n>=1){
            arr[i--] = n%2;
            n/=2;
        }
        int num = 0;
        for(int j=0; j<arr.length; j++){
            if(arr[j]==1){
                num+=(1<<j);
            }
        }
        return num;
    }
}