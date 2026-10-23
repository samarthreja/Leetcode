class Solution {
    public int sortPermutation(int[] nums) {
        int ans = -1;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] != i){
                ans = ans & nums[i];
            }
        }
        if(ans == -1){
            return 0;
        }
        else{
            return ans;
        }
    }
}