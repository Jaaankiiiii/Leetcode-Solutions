class Solution {
    public class Pair implements Comparable<Pair>{
        int el;
        int dist;
        Pair(int el, int dist){
            this.el = el;
            this.dist = dist;
        }
        public int compareTo(Pair p){
            if(this.dist==p.dist) return p.el-this.el;
            return p.dist-this.dist;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<arr.length; i++){
            int el = arr[i];
            int dist = Math.abs(x-el);
            pq.add(new Pair(el, dist));
            while(pq.size()>k){
                pq.remove();
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<k; i++){
            Pair p = pq.peek();
            ans.add(p.el);
            pq.remove();
        }
        Collections.sort(ans);
        return ans;
    }
}