//
// Note: You are allowed to add additional methods if you need.
// Coded by Prudence Wong 2020-12-15
//
// Name:Viraj Patel
// Student ID:201351707
//
// Time Complexity and explanation: You can use the following variables for easier reference.
// n denotes the number of requests, p denotes the size of the cache
// n and p can be different and there is no assumption which one is larger
//
//noEvict():
// Time Complexity for noEvict()is Linear , O(n) ,the Size of the Cache , and Request array are directly proportional for the algorithms runtime. as the 
 //evictFIFO():
// Time Complexiy for evictFIFO() is Quadratic O(n^2), the runtime of the algorithm grows directly proportional to the Sqared size of both input Arrays
 //evictLFU():
// Time complexity for evictLFU() is  , O(n),
 //evictLFD():
//

class COMP108A1Paging {

	// no eviction
	// Aim: 
	// do not evict any page
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output noEvict(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();
				
		int i, j;     // initialising variables to be used
		boolean flag;
		i = 0;  // setting the I varable to 0 , this wl be used as a pointer in the rArray
		while (i < rSize){ // setting a base case for the loop, the loop will terminate once each element of the rArray has been checked
			j = 0; // setting the varable j to 0 , this will be the pointer in the cArray
			flag = false;
			while (j < cSize && !flag){ 
				if (rArray[i] == cArray[j]) // if the element at postion I of the rArray matches the element at position J of the cArray then 
					flag = true; // Flag is called to break the loop
					System.out.print("h"); // h is printed to indicate a HIT
				j++; // J is appended by 1 to point to the next element of the cache array.
				
			}
			if (!flag) // if the elements of the list do not match then M is printed to indicate a Miss
				System.out.print("m");
			i++; // I is appended to point to the next element of the rArray
			
		}
		
		
		
		return output;
	}

	// evict FIFO
	// Aim: 
	// evict the number present in cache for longest time if next request is not in cache
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input: 
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictFIFO(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();
		int i, j;
		boolean flag;
		
		i = 0;
		while (i < rSize){
			j = 0;
			flag = false;
			while (j < cSize && !flag){
				if (rArray[i]==cArray[j])
				flag = true;
				System.out.print("h");
			j++;
			if (!flag)
				System.out.print("m");
				cArray[j] = rArray[i]; // the element at position J of the cache array is replaced with the element at position I of the Request array
			}
			i++;
		}
		
		


		return output;
	}

	// evict LFU
	// Aim:
	// evict the number that is least freently used so far if next request is not in cache
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries
	static COMP108A1Output evictLFU(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();
		
		int i ,j ,min; // initialising a variable MIN, to be used to store the current smallest value of the new countArray
		boolean flag;
		int k = 0;
		int y;
		int countArray [] = new int [cSize]; // Creating a new array to store the occurances times a Cache value is called
		while (k < cSize){
			countArray[k] = 1; 
			k++;  // creating a countArray of lenght cSize and 
				  // setting all values to one
		}
		i = 0;
		while (i < rSize){
			j = 0;
			flag = false;
			while (j < cSize && !flag){
				if (rArray[i]==cArray[j])
					flag = true;
					System.out.print("h");
					countArray[i] = countArray[i] + 1;
				j++;
				
				
		
			if (!flag)
				//min = cArray [0];    // finding the smallest element in the CountArray list
				//y = 1;
				//while (y < cArray.length){
				//	if (cArray[y] < min)
				//		min = cArray[y];
				//	y++;
				// As the Cache is only altered if there is a Miss, the method to find the smallest 
				// element of the count array is implemented here
				// if i could succesfully implement this, i would have stored the index value of 
				// the smallest position. and replaced it with the value from 
				// the rArray 
			
				System.out.print("m");
				;
			}
			i++;
		}
		
		return output;
	}

	
	
		

		// kept receiving errors, indicating the variable min was not initialised,
		// attempted to fix this bug many times but had no succes.
	

	// evict LFD
	// Aim:
	// evict the number whose next request is the latest
	// count number of hit and number of miss, and find the hit-miss pattern; return an object COMP108A1Output
	// Input:
	// cArray is an array containing the cache with cSize entries
	// rArray is an array containing the requeset sequence with rSize entries	
	static COMP108A1Output evictLFD(int[] cArray, int cSize, int[] rArray, int rSize) {
		COMP108A1Output output = new COMP108A1Output();
		int i ,j;
		boolean flag;
		int posArray[] = new int [cSize]; // creating an array to store the postion of the next request of cache elements
		
		i = 0;
		while(i < rSize ){
			j = 0;
			flag = false;
			while (j < cSize && !flag){
				if (rArray[i] == cArray[j])
					flag = true;
					System.out.print("h");
				j++;
				
			if (!flag)
				System.out.print("m");
			}
		 i++;
		}
		

		return output;
		// Struggled to implement this method
	}

}

