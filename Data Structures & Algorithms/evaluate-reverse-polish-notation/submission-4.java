class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")){
                int n2 = st.pop();
                int n1 = st.pop();
                int res = 0;
                switch(tokens[i]){
                    case "+":
                        res = n1+n2;
                        break;
                    case "-":
                        res = n1-n2;
                        break;
                    case "*":
                        res = n1*n2;
                        break;
                    case "/":
                        res = n1/n2;
                        break;
                }
                st.push(res);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
