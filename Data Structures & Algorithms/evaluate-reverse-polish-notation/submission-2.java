class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s: tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int n1 = st.pop();
                int n2 = st.pop();
                int res = 0;
                switch(s){
                    case "+":
                        res = n2+n1;
                        break;
                    case "-":
                        res = n2-n1;
                        break;
                    case "*":
                        res = n2*n1;
                        break;
                    case "/":
                        res = n2/n1;
                        break;
                }
                st.add(res);
            }else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
