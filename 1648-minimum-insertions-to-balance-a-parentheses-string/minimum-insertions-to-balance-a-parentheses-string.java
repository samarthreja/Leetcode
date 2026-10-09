class Solution {
    public int minInsertions(String s) {
        int cnt = 0;
        int open = 0;
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                open++;
            }
            else{
                if(i+1 < s.length() && s.charAt(i + 1) == ')'){
                    i++;
                }
                else{
                    cnt++;
                }
                if(open > 0){
                    open--;
                }
                else{
                    cnt++;
                }
            }
        }
        return cnt+2*open;
    }
}