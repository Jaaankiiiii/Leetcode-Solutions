class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length==2) return nums;
        int rightmost = 0;
        int num=0;
        for(int i=0; i<nums.length; i++){
            num^=nums[i];
        }
        rightmost = num & (-num);
        int b1=0;
        int b2=0;
        for(int i=0;i<nums.length;i++){
            if((nums[i] & rightmost)==0){
                b2^=nums[i];
            }else{
                b1^=nums[i];
            }
        }
        int[] ans=new int[2];
        ans[0]=b1;
        ans[1]=b2;
        return ans;
    }
}