class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int i = 0, j=0, sum = 0, minLen = Integer.MAX_VALUE, len = 0;
        while(j<n+1 && i<n){
            
            if(sum >= target) {
                len = j-i;
                minLen = Math.min(minLen, len);
                sum -= nums[i];
                i++;
            }
            else{
                if(j<n) sum += nums[j];
                j++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;





        // int n = nums.length;
        // int minLen = Integer.MAX_VALUE;
        // for(int i =0; i<n; i++){
        //     int sum = 0;
        //     for(int j=i; j<n; j++){
        //         if(sum<target){
        //             sum+=nums[j];
        //         }
        //         else{
        //             minLen = Math.min(minLen, j-i);
        //             break;
        //         }
        //     }
        //     if(sum>=target){
        //         minLen = Math.min(minLen, n-i);
        //     }
        // }
        // if(minLen == Integer.MAX_VALUE) return 0;
        // return minLen;
    }
}