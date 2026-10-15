class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i = 0; i <= n; i++){
            int curr = 0;
            if(i < n){
                curr = heights[i];
            }
            while(!st.isEmpty() && heights[st.peek()] > curr){
                int height = heights[st.pop()];
                int width = 0;
                if(st.isEmpty()){
                    width = i;
                }
                else{
                    width = i - st.peek() - 1;
                }
                int area = height * width;
                if(area > max){
                    max = area;
                }
            }
            if(i < n){
                st.push(i);
            }
        }
        return max;
        
    }
}