class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] prefixSum = new int[n];
        
        prefixSum[0]=nums[0];
        for(int i=1; i<n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int q = queries.length;
        int[] ans = new int[q];
        
        for(int i=0; i<q; i++){
            int low = 0;
            int high = n-1;
            int res = -1;
            while(low <= high){
                int mid = (high+low)/2;
                if(prefixSum[mid] <= queries[i]){
                    res = mid;
                    low = mid+1;
                }
                else high = mid-1;
            }
            ans[i] = res+1;
        }
        return ans;
    }
}