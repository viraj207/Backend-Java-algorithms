//
// Enter your name:
// Enter your student ID:
//
class COMP108W03 {

	// print the content of an array of size n
	static void printArray(int[] data, int n) {
		int i;

		for (i=0; i < n; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}

	// data[] is an array, n is size of array, key is the number we want to find
	static void seqSearch(int[] data, int n, int key) {
		int i, count;
		boolean found;

		// start sequential search on the array called data[]
		found = false;	// to indicate if the number is found
		i = 0;		// an index variable to iterate through the array
		count = 0;	// to count how many comparisons are made
		while (i<n && found==false) {
			if (data[i] == key) {
				found = true;
			} else {
				i = i+1;
			}
			count = count+1;
		}
		System.out.print("The number " + key + " is ");
		if (found == false)
			System.out.print("not ");
		System.out.println("found by sequential search and the number of comparisons used is " + count);
	}

	// data[] is an array in ascending order, n is size of array, key is the number we want to find
	// You can assume that data[] is already sorted
	// refer to Lecture 6
	static void binarySearch(int[] data, int n, int key) {
		int left = 0;
		int right = data.length - 1;  //finding the lenght of the Array, -1 is used as position 0 is counted as a position, but this is redundant in the search
		boolean found = false;
		int counter = 0;

		while (left <= right && found==false){
			int middle = (left + right)/2;
			if (data[middle] == key){
				found = true;
				System.out.println("Found");
			} else {
				if (key < data[middle])
					right = middle - 1;
				else {
					left = middle + 1;
					}

			}
		counter +=1;

		}
		if (found == false)
			System.out.println("Not Found");
		System.out.println("number of passes of the search : " + counter);
	}

	// print the smallest number in the array of size n
	static void findMin(int[] data, int n) {
		int i, min;

		min = data[0];
		i = 1;
		while (i < n) {
			if (data[i] < min)
				min = data[i];
			i++;
		}
		System.out.println("The smallest number is " + min + ".");
	}

	// print the largest number in the array of size n
	// refer to Lecture 8
	static void findMax(int[] data, int n) {
		int i, max;
		max = data[0];
		i = 1;
		while ( i < n){
			if (data [i] > max)
			max = data[i];
		i = i + 1 ;

		}
				System.out.println("The greatest number is " + max + ".");

	}

	// print the second smallest number in the array of size n
	// refer to Lecture 8
	static void findSecondMin(int[] data, int n) {
		int i ,min;
		int x ,min2;

		min = data[0];
		min2 = data[0];
		i = 1;
		while (i < n) {
			if (data[i] < min)
				min = data[i];
			i++;
		x = i + 1;

		}
		System.out.println("The smallest number is " + min + ".");


		System.out.println("The smallest number is " + min2 + "."); // ive played around with this , im trying to output the next value by appending the index by 1






	}

	// print the second largest number in the array of size n
	// refer to Lecture 8
	static void findSecondMax(int[] data, int n) {

	}

	// print the smallest number and its position in an array of size n
	// Find the bug and fix it by altering ONE line of code
	static void bugOne(int[] data, int n) {
		int i, pos, min;

		pos = 0;
		min = 0;
		i = 1;
		while (i < n) {
			if (data[i] < min) {
				min = data[i];
				pos = i;
			}
			i++;
		}
		System.out.println("The smallest number is " + min + " at position " + pos + ".");
	}
}
