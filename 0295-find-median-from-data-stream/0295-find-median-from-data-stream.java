class MedianFinder {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        if(maxHeap.size()==0) maxHeap.add(num);
        else{
            if(num < maxHeap.peek()) maxHeap.add(num);
            else minHeap.add(num);
        }

        if(maxHeap.size() == minHeap.size()+2) minHeap.add(maxHeap.remove());
        if(minHeap.size() == maxHeap.size()+2) maxHeap.add(minHeap.remove());
    }
    
    double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }else{
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            else return minHeap.peek();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */