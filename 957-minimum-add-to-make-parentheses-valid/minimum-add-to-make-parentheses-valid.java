class Solution {
    public int minAddToMakeValid(String s) {
        int l = 0;
        int r = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                l++;
            }
            else{
                if(l > 0){
                    l--;
                }
                else{
                    r++;
                }
            }
        }
        return l+r;
    }
}