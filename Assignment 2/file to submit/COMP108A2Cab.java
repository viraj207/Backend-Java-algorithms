//
// Note: You are allowed to add additional methods if you need.
// Coded by Prudence Wong 2021-03-06
//
// Name: Viraj Patel
// Student ID: 201351707
// MWS username: sgvpate02
//
// Time Complexity and explanation:
// f denotes initial cabinet size
// n denotes the total number of requests
// d denotes number of distinct requests
// x denoted number of disticnt request + initial cabinet size
// You can use any of the above notations or define additional notation as you wish.
//
// appendIfMiss():
// Time complexity for this is O(fn) , the Inner loop repeats itself n times 
// and the inner loop iterates for f times, therfore the overall time complexity would be multiplying
// both together.
//
//
// moveToFront():
// Time complexity of this algorithm is O(fn) the inner loop repeats itself n times
//and the inner loop interates for f times therfore the overall time
// complexity would be multiplying both together
//
//
// freqCount():
// Time complexity for this algorithm is O(fx) the inner loop repeats itself n times and the inner loop
// iterates itself x times. therfore the overall time complexity would be multiplying
// both together.

class COMP108A2Cab {

	public COMP108A2Node head, tail;

	public COMP108A2Cab() {
		head = null;
		tail = null;
	}
	// append to end of list when miss
	public COMP108A2Output appendIfMiss(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);
		int i;
		boolean flag; 
		COMP108A2Node curr;
		//creating a variable (i) to be used as the pointer for rArray
		i = 0;
		while(i < rSize){
			flag = false; // flag is used to indicate weather element at position i in rArray has been located in the linked list

			//setting the current node to be the head of the list
			curr = head;
			while(curr != null && !flag){
				output.compare[i] ++;  //Compare at index i is appended at we are counting the amount of times the outer
				if (rArray[i] == curr.data){ // while loop has been run.
					flag = true;
					output.hitCount ++; // if the element has been found we append the hitCount
				}
				else{
					curr = curr.next;
				}
			}
			if (!flag){
				//creating a new node holding the element at position i or rArray
				//and sending the newley created node to the premade insertTail function
				
				insertTail(new COMP108A2Node(rArray[i]));
				output.missCount++;
			}
			//appending pointer i to point to the next position of rArray
			i++;
		}
		output.cabFromTail = tailToHead();
		output.cabFromHead = headToTail();
		return output;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////

	// move the file requested to the beginning of the lis
	public COMP108A2Output moveToFront(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);
		int i;
		boolean flag;
		COMP108A2Node curr;
		//creating a variable (i) to be used as the pointer for rArrays
		i = 0;

		while(i < rSize){
			flag = false; // flag is used to indicate weather element at index i of rArray has been found in the linked list

			//setting the current node to be the head of the list
			curr = head;
			//HitCase
			while(curr != null && !flag){


				output.compare[i] ++;
				if (rArray[i] == curr.data){
					flag = true;
					output.hitCount ++; // if flag = true then hitCount is appended

				// Had difficulty implementing moving the requested data to the front of the linked list
				// this worked in some test cases but not in all
				// this led to an almost expected output being produced in some test cases
				// unsure why this bug has occured , has attempted to solve the issue, but to no avail.
					if (flag){
						
					
						if (curr != head){             // nothing needs to be done if  curr == head
							curr.prev.next = curr.next; 
							if (curr == tail)  // if curr is the last node then we cant access it
							tail = curr.prev;
							else{
								curr.next.prev = curr.prev;
								head.prev = curr; // previos node to head is made curr
								curr.next = head; // this means that we need the node after curr to equal head
								curr.prev = null; // as curr is at the front of the list, its previous node is null
								head = curr;   // head is now set as curr node
							}
				
						}
					}	
				}
				else{
					curr = curr.next;
				}
			}
			//Misscase
			if (head != curr && !flag ){  // if the head of the list doesnt equal whats at index i of rArray 
					insertHead  (new COMP108A2Node(rArray[i]));// element at position i at the request array is added to the head of the 
																//linked list
					output.missCount ++; //misscount is appended if !flag
			}


			//appending pointer i to point to the next position of rArray
			i++;

		}



		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		return output;
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////



	// move the file requested so that order is by non-increasing frequency
	public COMP108A2Output freqCount(int rArray[], int rSize) {
		COMP108A2Output output = new COMP108A2Output(rSize);
		boolean flag;
		COMP108A2Node curr;
		int i;
		i = 0;
		while(i < rSize){
			flag = false;
			//setting the current node to be the head of the list
			curr = head;
			while(curr != null && !flag){
				output.compare[i] ++;
				if (rArray[i] == curr.data){
				
					flag = true;
					curr.freq ++;  // when the element at position i of rArray is located , the freqency of that element is increased by one
					output.hitCount ++;
					
					
					//Struggled to implement moving the element with the largest frequency to the front of the list
					// however my attempt at implenting it is below
					// i have commented my attempt out as it was making my code fail more tests
					/*
					if (curr != head && curr.freq > curr.next.freq ){             
						curr.prev.next = curr.next; 
						if (curr == tail)  // if curr is the last node then we cant access it
							tail = curr.prev;
						else{
							head.prev = curr; // previos node to head is made curr
							curr.next = head; // this means that we need the node after curr to equal head
							curr.prev = null; // as curr is at the front of the list, its previous node is null
							head = curr;   // head is now set as curr node
						}
				
					}	
					*/
					
				}
				else{
					curr = curr.next;
				}
			}
			if (!flag){
				output.missCount++;
				//output.compare[i] ++;
				insertTail(new COMP108A2Node(rArray[i]));
			}
		//	else{
				//curr.freq ++;
			i++;
		}
		
		output.cabFromHead = headToTail();
		output.cabFromTail = tailToHead();
		output.cabFromHeadFreq = headToTailFreq();
		return output;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	// DO NOT change this method
	// insert newNode to head of list
	public void insertHead(COMP108A2Node newNode) {

		newNode.next = head;
		newNode.prev = null;
		if (head == null)
			tail = newNode;
		else
			head.prev = newNode;
		head = newNode;
	}

	// DO NOT change this method
	// insert newNode to tail of list
	public void insertTail(COMP108A2Node newNode) {

		newNode.next = null;
		newNode.prev = tail;
		if (tail != null)
			tail.next = newNode;
		else head = newNode;
		tail = newNode;
	}

	// DO NOT change this method
	// delete the node at the head of the linked list
	public COMP108A2Node deleteHead() {
		COMP108A2Node curr;

		curr = head;
		if (curr != null) {
			head = head.next;
			if (head == null)
				tail = null;
			else
				head.prev = null;
		}
		return curr;
	}

	// DO NOT change this method
	// empty the cabinet by repeatedly removing head from the list
	public void emptyCab() {
		while (head != null)
			deleteHead();
	}


	// DO NOT change this method
	// this will turn the list into a String from head to tail
	// Only to be used for output, do not use it to manipulate the list
	public String headToTail() {
		COMP108A2Node curr;
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
	// Only to be used for output, do not use it to manipulate the list
	public String tailToHead() {
		COMP108A2Node curr;
		String outString="";

		curr = tail;
		while (curr != null) {
			outString += curr.data;
			outString += ",";
			curr = curr.prev;
		}
		return outString;
	}

	// DO NOT change this method
	// this will turn the frequency of the list nodes into a String from head to tail
	// Only to be used for output, do not use it to manipulate the list
	public String headToTailFreq() {
		COMP108A2Node curr;
		String outString="";

		curr = head;
		while (curr != null) {
			outString += curr.freq;
			outString += ",";
			curr = curr.next;
		}
		return outString;
	}

}
