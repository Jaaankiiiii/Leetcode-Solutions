class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        int maxLen = 1;
        for(int x : set){
            int len=1;
            if(set.contains(x-1)) continue;
            while(set.contains(x+1)){
                x++;
                len++;
            }
            maxLen=Math.max(maxLen,len);
        }
        return maxLen;
    }
}