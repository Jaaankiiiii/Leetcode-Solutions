class Solution {
    public class Pair implements Comparable<Pair>{
        int el;
        int freq;
        Pair(int el, int freq){
            this.el = el;
            this.freq = freq;
        }
        public int compareTo(Pair p){
            if(this.freq==p.freq) return p.el - this.el;
            return this.freq-p.freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int f = map.get(nums[i]);
                map.put(nums[i],f+1);
            }else map.put(nums[i],1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }
        int[] ans = new int[nums.length];
        int i=0;
        while(pq.size()>0){
            Pair p = pq.peek();
            for(int j=0; j<p.freq; j++){
                ans[i++] = p.el;
            }
            pq.remove();
        }
        return ans;
    }
}