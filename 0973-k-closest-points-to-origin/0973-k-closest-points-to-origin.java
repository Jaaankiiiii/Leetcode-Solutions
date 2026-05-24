class Solution {
        public class Triplet implements Comparable<Triplet>{
            int d,x,y;
            Triplet(int d, int x, int y){
                this.d = d;
                this.x = x;
                this.y = y;
            }
            public int compareTo(Triplet t){
                return  t.d-this.d;
            }
        }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> pq = new PriorityQueue<>();
        for(int i =0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            pq.add(new Triplet(dist,x,y));
            if(pq.size()>k){
                pq.remove();
            }
        }
        int[][] ans = new int[k][2];
        int i=0;
        while(pq.size()>0){
            Triplet t = pq.peek();
            ans[i][0] = t.x;
            ans[i][1] = t.y;
            i++;
            pq.remove();
        }
        return ans;
    }
}