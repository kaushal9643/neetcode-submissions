class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int n2 = st.pop();
                int n1 = st.pop();
                int sum = 0;
                switch(tokens[i]){
                    case "+":
                        sum = n1+n2;
                        break;
                    case "*":
                        sum = n1*n2;
                        break;
                    case "-":
                        sum = n1-n2;
                        break;
                    case "/":
                        sum = n1/n2;
                        break;
                }
                st.push(sum);
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.pop();
    }
}
