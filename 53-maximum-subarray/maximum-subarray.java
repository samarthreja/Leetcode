class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxsum = Integer.MIN_VALUE;               //Kadane's Algorithm
        int currsum = 0;
        for(int i = 0; i<n; i++){
            currsum += nums[i];
            maxsum = Math.max(maxsum, currsum);
            if(currsum < 0){
                currsum = 0;
            }  
        }
        return maxsum;
    }
}