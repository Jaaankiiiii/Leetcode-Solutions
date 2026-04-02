class Solution {
    public int singleNumber(int[] nums) {
        // Arrays.sort(nums);
        int x =0;
        for(int i =0; i<nums.length; i++){
            // if(nums[i]==nums[i+1]) continue;
            // else return nums[i];
            x ^= nums[i];
        }
        return x;
        
    }
}