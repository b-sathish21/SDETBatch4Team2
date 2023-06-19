class MyQueue {
	//Complexity: Time- O(n) | Space- O(n)
	// initiating two stack to add data at last
	protected Stack<Integer> primary; // considering as queue
	protected Stack<Integer> secondary; // to support temp for queue
	protected int size = 0; // initating size to view the size of the queue

    public MyQueue() {
			// initiating the stacks declared
    	this.primary = new Stack<>();
    	this.secondary = new Stack<>();
    }
    
    public void push(int x) {
			/**
			Validating the size of queue is zero
				then add to primary stack directly
			else
				initiate loop to pop all the data from primary and push to secondary
				add the data to the primary
				initiate loop to pop all the data from secondary and push to primary
			increment size by one
			 */
    	if(size == 0) primary.push(x);
    	else {
    		while(primary.size() != 0) secondary.push(primary.pop());
				primary.push(x);
				while(secondary.size() != 0) primary.push(secondary.pop());
    	}
    	size++;
    }
    
    public int pop() {
			/**
			validate queue size is not zero
				decrement size by one
				return the data in top poping from primary
			else
				throw exception
			 */
			if (size != 0) {
				size--;
				return primary.pop(); 
			}
			else throw new NullPointerException("Queue is empty");        
    }
    
    public int peek() {
			/**
			validate queue size is not zero
				return the data in top from primary
			else
				throw exception
			 */
		if (size != 0) return primary.peek(); 
		else throw new NullPointerException("Queue is empty");
    }
    
    public boolean empty() {
			/**
			validate queue size is not zero
				return false
			return true
			 */
    	if(size != 0) return false;
      return true;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */