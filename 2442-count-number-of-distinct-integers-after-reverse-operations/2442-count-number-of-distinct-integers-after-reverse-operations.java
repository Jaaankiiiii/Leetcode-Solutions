class Solution {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
            set.add(reverse(nums[i]));
        }
        return set.size();
    }
    public int reverse(int nums){
        int rev = 0;
        while(nums>0){
            int r = nums%10;
            rev = rev*10+r;
            nums /= 10;
        }
        return rev;
    }
}