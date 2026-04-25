class MinStack {
    Stack<Integer> mainSt;
    Stack<Integer> minSt;
    public MinStack() {
        mainSt = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        mainSt.push(val);
        if(minSt.isEmpty() || val <= minSt.peek()){
            minSt.push(val);
        }
    }
    
    public void pop() {
        int n = mainSt.pop();
        if(minSt.peek() == n){
            minSt.pop();
        }
    }
    
    public int top() {
        return mainSt.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}
