class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int ele = 0;                       //moores voting algorithm
        int cnt = 0;
        for(int i = 0; i<n; i++){
            if(cnt == 0){
                cnt = 1;
                ele = nums[i];
            }
            else if(ele == nums[i]){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        int count = 0;
        for(int i = 0; i<n; i++){
            if(nums[i] == ele){
                count++;
            }
        }
        if(count > (n/2)) return ele;
        return -1;
    }
}