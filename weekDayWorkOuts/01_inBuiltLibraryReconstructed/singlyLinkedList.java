package inBuiltLibraryReconstructed;

public class singlyLinkedList {
	/*
	 * Node:
	 * 		___________
	 * 		|data|next|
	 * 		-----------
	 */
	
	class Node{
		
		String data = null;
		
		Node next = null;
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
			 * 	head		P			  P  tail
			 * 	___________   ___________   ___________   
			 * 	|data|next|-->|data|next|-->|data|next|-->null
			 * 	-----------	  -----------   -----------
			 * 	start		  current-->travels to next node till null
			 * then add node next to the current
			 */
			Node current = start;
			while(current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
		size++;
	}
	
	/*
	 * Insert method
	 * ==========
	 * takes parameter/ argument and returns nothing
	 * here we pass the data and index where the data to be inserted
	 * Node:
	 * 	head		P			  P  tail
	 * 	___________   ___________   ___________   
	 * 	|data|next|-->|data|next|-->|data|next|-->null
	 * 	-----------	  -----------   -----------
	 * 	start
	 * 					___________
	 * 					|data|next|
	 * 					-----------
	 * 					Insert Node
	 * 
	 * 		|data|next|-->|data|next|--				   -->|data|next|-->null
	 * 		start          current    | 			   |
	 * 								   --->|data|next|--
	 * 										node 
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
			start = node;
		}
		else {
			Node current = start;
			for(int i=1; i < index -1; i++) current = current.next;
			node.next = current.next;
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
		 * then we point the Start next pointer to the start
		 * Node: Start |data|next|--
		 * 			    	        |
		 * 		    				-->|data|next|-->null
		 * Node: |data|next|-->null
		 * 		  START
		 */
		while(start != null || start.data.equals(data)) {
			start = start.next;
			size--;
		}
		
		Node current = start.next; //assign pointer to current
		Node previous = start; //assign Head node to previous to travel till we find the match of the data
		while(current != null) {//validating pointer is not null
			if(current.data.equals(data)) {
				previous.next = current.next; //redirecting the origin point of the current pointer to previous node pointer
				size--;
			}
			previous = current; // moving the node
			current = current.next; // moving the pointer
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