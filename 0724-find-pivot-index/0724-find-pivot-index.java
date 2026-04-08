class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        for(int i=1; i<n; i++){
            nums[i] += nums[i-1];
        }

        for(int i=0; i<n; i++){
            int left = nums[i];
            int right = i==0 ? nums[n-1] : nums[n-1]-nums[i-1];
            if(left==right) return i;
        }
        return -1;










        //BRUTE FORCE
        // int n = nums.length;
        // for(int i=0; i<n; i++){
        //     int leftSum = 0;
        //     int rightSum = 0;
        //     for(int j=0; j<i; j++){
        //         leftSum += nums[j];
        //     }
        //     for(int j=i+1; j<n; j++){
        //         rightSum += nums[j];
        //     }
        
        //     if(leftSum==rightSum){
        //         return i;
        //     }
        // }
        // return -1;
    }
}