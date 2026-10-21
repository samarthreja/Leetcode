class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        char min = s.charAt(0);
        char max = s.charAt(0);
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(i > 0 && ch < s.charAt(i - 1)){
                sorted = false;
            }
            min = (char) Math.min(ch, min);
            max = (char) Math.max(ch, max);
        }
        if(sorted){
            return 0;
        }
        if(n == 2){
            return -1;
        }
        if(s.charAt(0) == min || s.charAt(n - 1) == max){
            return 1;
        }
        for(int i = 1; i < n-1 ; i++){
            if(s.charAt(i) == min || s.charAt(i) == max){
                return 2;
            }
        }
        return 3;
    }
}