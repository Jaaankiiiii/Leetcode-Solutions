class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int x : nums){
            totalSum += x;
        }

        int rightSum = totalSum;
        int leftSum = 0;
        for(int i=0; i<n; i++){
            if(i==0){
                leftSum = 0;
            }else leftSum += nums[i-1];
            rightSum -= (nums[i]);
            if(leftSum==rightSum){
                return i;
            }
        }
        return -1;
    }
}