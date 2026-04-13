class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        //prefix sum
        for(int i=1; i<n; i++){
            nums[i] += nums[i-1];
        }

        for(int i=0; i<n; i++){
            if(nums[i]==k) count++;

            int rem = nums[i]-k;
            if(map.containsKey(rem)){
                count += map.get(rem);
            }
            if(map.containsKey(nums[i])){
                int f = map.get(nums[i]);
                map.put(nums[i],f+1);
            }else{
                map.put(nums[i],1);
            }
        }
        return count;
    }
}