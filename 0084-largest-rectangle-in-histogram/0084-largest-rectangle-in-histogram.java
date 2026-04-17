class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for(int i=0; i<=n; i++){
            int currentHeight = (i==n)? -1:heights[i];
            while(!st.isEmpty() && currentHeight < heights[st.peek()]){
                int height = heights[st.pop()];
                int right = i;
                int left = st.isEmpty() ? -1 : st.peek();
                int width = right-left-1;
                int area = width*height;
                
                maxArea = Math.max(maxArea,area);
            }
            st.push(i);
        }
        return maxArea;
    }
}