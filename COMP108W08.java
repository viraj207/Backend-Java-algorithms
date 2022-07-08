//
// by Prudence Wong 2021-03-20
//
// Name: Viraj Patel
// Student ID: 201351707
//
// Time complexity: 
// Express the worst case time complexity of your algorithm in big-O notation.
// You can assume that there are 
// n nodes in the original database list, 
// r requests in the request sequence, and 
// k distinct requests in the request sequence.
// Justify your answer.
//
// notExisits: Time complexity is O(n), time complexity will be multiplying the inner and outerloop.
//
// count: Time complexity is O(n) , to count the number of occurancesd of an element you need to traverse the ehole list.
//

///// ERROR : couldnt get my code to compile due to a variable error,
// i couldnt identify how to establish the lenght of the database.

class COMP108W08 {

	public Node head, tail;
	
	public COMP108W08() {
		head = null;
		tail = null;
		//Node current = node;
	}
	int elem = 0;
	int pointer = 0;

	// Input: array[] with size entries
	// print all entries of array[] that does not exist in the list
	//array is the request sequence
	//size id number of movies in request sequence
	public void notExists(int array[], int size) {
		int i ,j;
		boolean flag;
		Node curr;
		curr = head;
		i = 0;
		while (i < size){
			j = 0;
			flag = false;
			while (j < outString.length && !flag){
				if (array[i] == curr.data)
					flag = true;
					head = head.next;
				j++;
				
			}
			if (!flag)
				System.out.println(array[i] +" ");
			i++;
			
		}
	}


	

	
	
	// Input: array[] with size entries 
	// for each entry in the list, count how many times it appears in array[]
	public void count(int array[], int size) {
		int i ,j;
		boolean flag;
		Node curr;
		curr = head;
		int count = 0;
		i = 0;
		while (i < size){
			j = 0;
			flag = false;
			while (j < outString.length && !flag){
				if (array[i] != curr.data)
					flag = true;
					head = head.next;
					count++;
					
				j++;
				
			}
			if (!flag)
			System.out.print(array[i]);
			System.out.print(count);
			
			count = 0;
				
			i++;
			
		}
		

	}

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
	public String headToTail(){
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
	public String tailToHead(){
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
