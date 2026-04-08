class Solution {
    public long[] findPrefixScore(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        long[] arr = new long[n];
        for(int i=0; i<n; i++){
            if(max < nums[i]) max = nums[i];
            arr[i] = nums[i] + max;
        }

        for(int i=1; i<n; i++){
            arr[i] = arr[i] + arr[i-1];
        }
        return arr;
    }
}