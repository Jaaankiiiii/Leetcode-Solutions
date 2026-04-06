class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        for(int i=0; i<31; i++){
            if((start>>i)%2 != (goal>>i)%2) count++;
        }
        return count;
    }
}