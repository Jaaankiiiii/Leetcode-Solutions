class Solution {
    class Triplet implements Comparable<Triplet> {
        int n;
        int r;
        int c;
        Triplet(int n, int r, int c){
            this.n = n;
            this.r = r;
            this.c = c;
        }
        public int compareTo(Triplet t){
            return this.n - t.n;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int minRange = Integer.MAX_VALUE;
        int[] arr = new int[2];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.size(); i++){
            int value = nums.get(i).get(0);
            max = Math.max(max,value);
            pq.add(new Triplet(value, i, 0));
        }
        // pq.add(new Triplet(nums.get(0).get(0),0,0));
        // pq.add(new Triplet(nums.get(1).get(0),1,0));
        // pq.add(new Triplet(nums.get(2).get(0),2,0));
        while(pq.size() == nums.size()){
            // int max = max(max(nums[0,0],nums[1,0]),nums[2,0]);
            Triplet t = pq.remove();
            int range = max-t.n;
            if(range < minRange) {
                minRange = range;
                arr[0] = t.n;
                arr[1] = max;
            }
            if(t.c+1 < nums.get(t.r).size()){
                int newNum = nums.get(t.r).get(t.c + 1);
                int newR = t.r;
                int newC = t.c + 1;
                pq.add(new Triplet(newNum, newR, newC));
                if(newNum > max){
                    max=newNum;
                }
            }
        }
        return arr;
    }
}