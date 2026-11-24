class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i<n; i++){
            long p = 1;
            long g = 0;
            long l = 1;
            for(int j = i; j<n; j++){
                p = p * nums[j];
                g = gcd(g, nums[j]);
                l = (l / gcd(l, nums[j])) * nums[j];
                if(p == g * l){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
    public long gcd(long a, long b){
        while(b != 0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}