class Solution {
    public int longestSubarray(int[] nums) {
        int i=0, j=0, idx=-1, maxCount=Integer.MIN_VALUE, n=nums.length;
        while( j < n ){
            if(nums[j] == 0){
                if(idx==-1){
                    idx=j;
                }else{ //already 0 exist before
                    i=idx+1;
                    idx=j;
                }
            }
            maxCount = Math.max(maxCount, j-i);
            j++;
            
        }
        return maxCount;
    }
}