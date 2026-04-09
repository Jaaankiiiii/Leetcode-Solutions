class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];
        Arrays.fill(prefixProd,1);
        Arrays.fill(suffixProd,1);

        //for prefixProd
        for(int i=1; i<n; i++){
            prefixProd[i] = prefixProd[i-1] * nums[i-1];
        }

        //for suffixProd
        for(int i=n-2; i>=0; i--){
            suffixProd[i] = suffixProd[i+1] * nums[i+1];
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = prefixProd[i] * suffixProd[i];
        }
        return ans;
    }
}