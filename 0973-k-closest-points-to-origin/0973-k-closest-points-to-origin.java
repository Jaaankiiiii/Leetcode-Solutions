class Solution {
    public class Triplet implements Comparable<Triplet>{
        int d;
        int x;
        int y;
        Triplet(int d, int x, int y){
            this.d = d;
            this.x = x;
            this.y = y;
        }
        public int compareTo(Triplet t){
            return this.d - t.d;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        if(k==points.length) return points;
        int n = points.length;
        PriorityQueue<Triplet> heap = new PriorityQueue(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            int x = points[i][0];
            int y = points[i][1];
            int d = x*x + y*y;
            heap.add(new Triplet(d,x,y));
            if(heap.size()>k) heap.remove();
        
        }
        int[][] ans = new int[k][2];
        int index = 0;
       for(int i=0; i<k; i++){
            Triplet t = heap.peek();
            ans[i][0] = t.x;
            ans[i][1] = t.y;
            //index++;
            heap.remove();             
        }
        return ans;

    }
}