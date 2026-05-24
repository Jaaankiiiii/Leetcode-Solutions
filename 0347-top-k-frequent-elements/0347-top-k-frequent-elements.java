class Solution {
    public class Pair implements Comparable<Pair>{
        int el;
        int freq;
        Pair(int el, int freq){
            this.el = el;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            return this.freq-p.freq;
        }
    }
    public int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i =0; i<n; i++){
            if(map.containsKey(arr[i])){
                int freq = map.get(arr[i]);
                map.put(arr[i],freq+1);
            }
            else map.put(arr[i],1);
        }
        PriorityQueue<Pair> pq  = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(new Pair(key, map.get(key)));
            while(pq.size()>k){
                pq.remove();
            }
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            Pair p = pq.peek();
            ans[i]=p.el;
            pq.remove();
        }
        return ans;
    }
}