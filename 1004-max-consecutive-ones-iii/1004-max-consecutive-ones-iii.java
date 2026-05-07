class Solution {
    // public int longestOnes(int[] nums, int k) {
    //     int i =0, j=0, maxCount=0, n = nums.length;
    //     Queue<Integer> q = new LinkedList<>();
       
    //     while(j<n){
    //         if(nums[j]==0){
    //             q.offer(j);
    //         }
    //         if(q.size() > k){
    //             i=q.poll()+1;
    //         }
    //         maxCount = Math.max(maxCount,j-i+1);
    //         j++;
    //     }
    //     return maxCount;
    // }
    public int longestOnes(int[] nums, int k) {
        int i =0, j=0, maxCount=0, n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        int zeroCount=0;
        while(j<n){
            if(nums[j]==0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[i]==0){
                    zeroCount--;
                }
                i++;
            }
            maxCount = Math.max(maxCount,j-i+1);
            j++;
        }
        return maxCount;
    }
}