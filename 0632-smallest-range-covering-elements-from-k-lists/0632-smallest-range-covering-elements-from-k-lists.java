class Solution {
    class Triplet implements Comparable <Triplet>{
        int n;
        int r;
        int c;
        Triplet(int n, int r, int c){
            this.n = n;
            this.r = r;
            this.c = c;
        }
        public int compareTo(Triplet t){
            return this.n-t.n;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.size(); i++){
            int num = nums.get(i).get(0);
            if(num >max) max = num;
            pq.add(new Triplet(num,i,0));
            
        }
        
        int minRange = Integer.MAX_VALUE;
        int[] arr= new int[2];
        while(pq.size()==nums.size()){
            Triplet t = pq.remove();
            int row = t.r;
            int col = t.c;
            int range = max - t.n;
            if(range < minRange){
                minRange = range;
                arr[0] = t.n;
                arr[1] = max;
            }
           
            // int num = t.n;
            if(t.c+1 < nums.get(t.r).size()){
                int newnum = nums.get(row).get(col+1);
                if(newnum > max) max = newnum;
                pq.add(new Triplet(newnum, row, col+1));
            }
        }
        return arr;
    }
}