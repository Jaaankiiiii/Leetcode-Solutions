class Solution {
    public int longestSubarray(int[] nums) {
        int i=0, j=0, idx=-1, maxCount=Integer.MIN_VALUE, n=nums.length;
        for(int k=0; k<n; k++){
            if(nums[k]!=0){
                i=k;
                j=k;
                break;
            }
        }
        int count=0;
        while( j < n && i < n ){
            if(nums[j] == 0 && idx==-1){
                idx=j;
                // count++;
                j++;
            }
            else if (nums[j] == 1){
                count++;
                j++;
            }else{
                if(count>maxCount) maxCount=count;
                i=idx+1;
                count=0;
                idx=-1;
                j=i;
            }
        }
        if(maxCount < count) maxCount=count;
        if(count==n) return n-1;
        return maxCount;
    }
}