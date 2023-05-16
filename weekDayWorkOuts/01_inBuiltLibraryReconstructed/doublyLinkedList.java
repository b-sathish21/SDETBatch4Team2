package inBuiltLibraryReconstructed;

public class doublyLinkedList {

	/*
	 * Node:
	 * 		________________
	 * 		|prev|data|next|
	 * 		----------------
	 */
	
	class Node{
		
		String data = null;
		
		Node next = null;
		
		Node previous = null;
	}
	
	/*
	 * head == start point == null in initial
	 * initial size of the list is zero
	 */
	Node start = null;
	int size = 0;
	
	
	/*
	 * Add method
	 * ==========
	 * takes parameter/ argument and returns nothing
	 * here since data declared as string, pass argument as "String data"
	 */
	public void add(String data) {
		// creating object for the node class created and calling here
		Node node = new Node();
		node.data = data; // adding the data into node		
		/*
		 * Node:
		 * 	-->null
		 * start == node
		 * node |data|next|-->null
		 *  	start
		 */
		if(start == null) start = node;
		else {
			/*
			 * Node:
			 * 	head		P			         P  tail
			 * 	  
			 * 	|data|next|<-->|prev|data|next|<-->|prev|data|next|-->null
			 * 
			 * 	start		     current-->travels to next node till null
			 * then add node next to the current
			 * while node prev pointer is assigned to the current node
			 * and current node next pointer is assigned to node to be added
			 */
			Node current = start;
			while(current.next != null) {
				current = current.next;
			}
			current.next = node;
			node.previous = current;
		}
		size++;
	}
	

	/*
	 * Insert method
	 * ==========
	 * takes parameter/ argument and returns nothing
	 * here we pass the data and index where the data to be inserted
	 * Node:
	 * 	head		P			       P  tail
	 * 	 
	 * 	|data|next|-->|prev|data|next|-->|prev|data|next|-->null
	 * 	
	 * 	start
	 * 					|data|next|
	 * 					
	 * 					Insert Node
	 * 
	 * 		|data|next|-->|prev|data|next|---				       -->|prev|data|next|-->null
	 * 		start          current   		 | 					   |
	 * 								  		 --->|prev|data|next|--
	 * 													node 
	 */
	public void insert(int index, String data) throws Exception {
		/*
		 * when index is less than 1 or greater than list size + 1
		 * then we can't insert the given node
		 * so we throw exception
		 */
		if(index > size+1 || index < 1) {
			throw new Exception("Node can't be inserted in the given index " + index + " as the size is " + size);
		}
		
		// creating object for the node class created and calling here
		Node node = new Node();
		node.data = data; // adding the data into node	
		
		/*
		 * If the node to be inserted at first position i.e. START
		 * then we point the node next pointer to the start
		 * and add node to the start
		 * 
		 * node: |data|next|
		 * 
		 * Node: |data|next|-->null
		 * 		  START
		 * 
		 * Node: node |data|next|--
		 * 			^   		  |
		 * 		    |			  -->|data|next|-->null
		 * 			------------------START
		 */
		if(index == 1) {
			node.next = start;
			start.previous = node;
			start = node;
		}
		else {
			Node current = start;
			for(int i=1; i < index -1; i++) current = current.next;
			node.next = current.next;
			node.previous = current;
			if(current.next != null) current.next.previous = node;
			current.next = node;
		}
		size++;
	}

	
	/*
	 * Remove method
	 * =============
	 * here we remove all the matching element
	 * takes parameter/ argument and returns nothing
	 * here we pass the data and index where the data to be inserted
	 * Node: 
	 * 		|data|next|-->|data|next|--				   -->|data|next|-->null
	 * 		start          current    | 			   |
	 * 								   --->|data|next|--
	 * 										node - Remove 
	 *  
	 * 		|data|next|-->|data|next|--------------------->|data|next|-->null
	 * 		start          current    
	 * 								   --->|data|next|--
	 * 										node - Remove 
	 */
	public void remove(String data) {
		// if the list is empty then we don't remove any.
		if(start == null || start.next == null) return;		
		/*
		 * If the node to be removed is at first position i.e. START
		 * then we point the current(next node of start) prev pointer to the null
		 * Node: Start |data|next|--
		 * 			    	        |
		 * 		    				-->|prev|data|next|-->null
		 * Node: null<--|prev|data|next|-->null
		 * 		  			  START
		 */
		while(start != null || start.data.equals(data)) {
			start = start.next;
			if(start != null) start.previous = null;
			size--;
		}
		
		Node current = start; //assign Head node to current to travel till we find the match of the data
		while(current != null) {//validating node is not null
			if(current.data.equals(data)) { //if data available
				current.previous.next = current.next; // changing the current's next pointer to current-1's next
				if(current.next != null) current.next.previous = current.previous; // changing current's previous pointer to current+1's previous pointer
				current.previous = null; //removing the current pointer
				size--;
			}
			current = current.next; // moving the node
		}
	}

	
	public int getIndex(String data) {
		Node current = start;
		// if the list is empty then we return -1.
		if(start == null || start.next == null) return -1;
		else {
			for(int index=1;index<=size;index++) {
				if(current.data.equals(data)) return index;
				current = current.next;
			}
		}		
		return -1;
	}
	
	public String fetchData(int index) throws Exception {
		Node current = start;
		// if the list is empty then we return -1.
		if(start == null || start.next == null) return "Empty List";
		else {
			for(int i=1;i<=size;i++) {
				if(i == index) return current.data;
				current = current.next;
			}
		}
		return "data not found";
	}
	
	public int len() {
		return size;
	}
	
	//To print the list after converting to String
	public String toStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		Node current = start;
		while(current != null) {
			sb.append(current.data + ", ");
			current = current.next;
		}
		sb.append("]");
		return sb.toString();
	}
}