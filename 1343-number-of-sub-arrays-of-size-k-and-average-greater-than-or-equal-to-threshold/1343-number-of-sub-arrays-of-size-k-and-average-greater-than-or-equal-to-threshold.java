class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
        int i = 0, j, avg=0, count=0;
        int sum =0;
        for(j=0; j < i+k; j++){
            sum+=arr[j];
        }
        avg = sum/k;
        if(avg>=threshold) count++;
        i++;
        while(j<n){
            sum = sum - arr[i-1] + arr[j];
            avg = sum/k;
            count += (avg >= threshold) ? 1 : 0;
            i++;
            j++;
        }
        return count;
    }
}