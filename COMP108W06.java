//
// Enter your name: Viraj Patel
// Enter your student ID : 201351707
 //

class COMP108W06 {

	public Node head, tail;
	
	public COMP108W06() {
		head = null;
		tail = null;
	}

	// sequential search if key is in the list
	// return true or false accordingly
	// Do NOT change its signature
	// You should implement a list traversal algorithm here
	public boolean seqSearchList(int key) {
		int i = 1;
		Node current = head;
		boolean found = false;
		if (head == null){
			System.out.print("List is empty.");
		}
		else {
			while(current != null){
				if(current.data == key){
					found = true;
					break;
				}
				i++;
				current = current.next;
			}
		}
		if (found)
			return found;
		else 
			return false;
	}

	// sequential search to count how many times key appears is in the list
	// return the count
	// Do NOT change its signature
	// You should implement a list traversal algorithm here
	public int countList(int key) {
		int count=0;
		int i = 1;
		Node current = head;
		boolean found = false;
		if (head == null){
			System.out.print("List is empty.");
		}
		else {
			while(current != null){
				if (current.data == key){
					found = true;
					count++;
				}
				i++;
				current = current.next;
			}
		}
		return count;
	}

	// finding the minimum number in the list
	// return the minimum
	// Do NOT change its signature
	// You should implement a list traversal algorithm here
	public int searchMin() { // Struggled to succsefully implement this method
		int min =Integer.MAX_VALUE; // kept receiving errors , saying i was unable to change from node to INT
		int i = 1;                  // ive commented out my attempt to implement this method in order for code to compile
		Node current = head;
		if (head == null){
			System.out.print("List is empty.");
		}
		else{
			System.out.print(current.next);
//			while(current != null){
//				if (current < current.next);
//				min = current.next;
//			}
//			i++;
//			current = current.next;
		}
			return min;
	}


	// finding the maximum number in the list
	// return the maximum
	// Do NOT change its signature
	// You should implement a list traversal algorithm here
	public int searchMax() {
		int max=Integer.MIN_VALUE;    // again, received same error as before
		int i = 1;                   // ive commented out my attempt of solving this method
		Node current = head;
		if (head == null){
			System.out.print("List is empty.");
		}
//		else{
//			while(current != null){
//				if (current > current.next);
//				max = current.next;
//			}
//			i++;
			current = current.next;
//		}
		
		
		return max;
	}





///////////////////////////////////////////////////////////////////////////////////////////


	// DO NOT change this method
	// insert newNode to the head of the list
	public void insertHead(Node newNode) {
		newNode.next = head;
		newNode.prev = null;
		if (head == null)
			tail = newNode;
		else
			head.prev = newNode;
		head = newNode;
	}

	// DO NOT change this method
	// insert newNode to the tail of the list
	public void insertTail(Node newNode) {
		newNode.next = null;
		newNode.prev = tail;
		if (tail != null)
			tail.next = newNode;
		else head = newNode;
		tail = newNode;
	}

	// DO NOT change this method
	// this will turn the list into a String from head to tail
	// This is only here to ease outputing the list content.
	// You should not use it in your list traversal.
	public String headToTail() {
		Node curr;
		String outString="";
		
		curr = head;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

	// DO NOT change this method
	// this will turn the list into a String from tail to head
	// This is only here to ease outputing the list content.
	// You should not use it in your list traversal.
	public String tailToHead() {
		Node curr;
		String outString="";
		
		curr = tail;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.prev;
		}
		return outString;
	}

}
