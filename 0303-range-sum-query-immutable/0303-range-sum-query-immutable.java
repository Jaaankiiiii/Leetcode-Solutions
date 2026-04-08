class NumArray {
    int[] arr;
    int[] prefix;
    public NumArray(int[] nums) {
        arr = nums;
        prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            prefix[i] = arr[i] + prefix[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0) return prefix[right];
        return prefix[right]-prefix[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */