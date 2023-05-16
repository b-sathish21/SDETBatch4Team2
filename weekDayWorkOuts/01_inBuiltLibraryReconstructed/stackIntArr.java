package inBuiltLibraryReconstructed;

public class stackIntArr {
	/*
	 * Stack is of array concept
	 * has the following actions
	 * 		- push()
	 * 		- pop()
	 * 		- peek()
	 * 		- find()
	 * 		- size()
	 */
	//Initializing the stack size and its pointer
	private int size = 50, top = 0;
	
	//Initializing the array variable to get the data
	private int ch[] = new int[size];
	
	/*
	 * Push Method
	 * ===========
	 * 		
	 * 		|data1|------
	 * 					|
	 * 				   	V
	 * 				|old data|
	 */
	public boolean push(int ele) {
		//validate top position is less than size
		if(top<size) {
			ch[top] = ele; // add the data1 above the old data
			top++; // increase the top position by one
			return true;
		}
		return false;		
	}
	
	/*
	 * Peek Method
	 * ===========
	 * 			------- read top
	 * 			|
	 * 			V
	 * 		|data1|
	 * 		|old data|
	 */
	public int peek () {
		//validate top position is less than size
		if(top<size) return ch[top - 1];
		return -1;		
	}
	
	/*
	 * Pop Method
	 * ===========
	 * 			------- remove top
	 * 			|
	 * 			V
	 * 		|data1|
	 * 		|old data|
	 */
	public int pop () throws Exception {
		//validate top position is less than size
		if(top<size) return ch[--top];
		else throw new Exception("No data available");
	}

	
	/*
	 * Size Method
	 * ===========
	 * 		Return top
	 */
	public int size () {
		if(top==0) return 0;
		return top;
	}

	/*
	 * Find Method
	 * ===========
	 * 			
	 * 		|data1| <-- find
	 * 		|old data|
	 */
	public int findindex (int ele) throws Exception {
		if(top!=0) {
			for(int i = 0; i<top; i++) {
				if(ch[i] == ele) return i;
			}
		}
		else throw new Exception("Data not available");
		return -1;
	}

	/*
	 * Fetch Method
	 * ===========
	 * 			
	 * 		|data1| <-- find
	 * 		|old data|
	 */
	public int fetchData (int index) throws Exception {
		if(top!=0) {
			for(int i = 0; i<top; i++) {
				if(i == index) return ch[i];
			}
		}
		else throw new Exception("Data not available");
		return -1;
	}
	
	//To print the stack after converting to String
	public String toStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		int i = 0;
		for(; i < top-1; i++) sb.append(ch[i] + ", ");
		sb.append(ch[i] + "]");
		return sb.toString();
	}
}
