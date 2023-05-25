class MyStack {
    public Queue<Integer> stck;
    public Queue<Integer> temp;
    public int size = 0;

    public MyStack() {
        this.stck = new LinkedList<>();
        this.temp = new LinkedList<>();
    }
    
    public void push(int x) {
        if(size == 0){
            stck.offer(x);
        }
        else{
            for(int i=0; i<size; i++) temp.offer(stck.poll());
            stck.offer(x);
            for(int i=0; i<size; i++) stck.offer(temp.poll());
        }
        size++;
    }
    
    public int pop() {
        if(size != 0) {
            size--;
            return stck.poll();
        }
        else throw new NullPointerException("Queue is empty");
    }
    
    public int top() {
        return stck.peek();
    }
    
    public boolean empty() {
        if(size == 0) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */