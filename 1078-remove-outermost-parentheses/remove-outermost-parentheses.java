class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String res = "";
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(st.size() > 0){
                    res = res + ch;
                }
                st.push(ch);
            }
            else{
                if(st.size() > 1){
                    res = res + ch;
                }
                st.pop();
            }
        }
        return res;
    }
}