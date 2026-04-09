class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n];
        // int[] suffixProd = new int[n];

        prefixProd[0] = 1;
        //for prefixProd
        for(int i=1; i<n; i++){
            prefixProd[i] = prefixProd[i-1] * nums[i-1];
        }

        // suffixProd[0] = 1;
        // //for suffixProd
        // for(int i=n-2; i>=0; i--){
        //     suffixProd[i] = suffixProd[i+1] * nums[i+1];
        // }
        int suffixProd = 1;
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--){
            ans[i] = prefixProd[i] * suffixProd;
            suffixProd = suffixProd * nums[i];
        }
        return ans;
    }
}