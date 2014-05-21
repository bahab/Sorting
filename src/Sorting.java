import java.util.Random;

public class Sorting {
	public static int[] numbers = new int[200];

	/**
	 * This is for you to fill out!
	 * @param number
	 */
	public static void simpleSearch(int number) {
		System.out.println("simpleSort()");
		// find the number in the array numbers
		boolean searching = true;
		int index = 0;
		while (searching) {
			System.out.println("["+index + "] = " + numbers[index]);
			if (numbers[index] == number) {
				System.out.println(numbers[index]+ " was found at [" + (index)+"]");
				searching = false;
			}
			index++;
			pause(500);
		}

	}

	/**
	 * finds a number in a sorted array 
	 * 
	 * Not for the easily scared! 
	 * 
	 * @param number - the number to be found. 
	 */
	public static void findNumberInArray(int number) {
		System.out.println("findNumberInArray()");
		
		boolean searching = true; //We have yet to find the number
		
		int index = numbers.length / 2; //We need to start in the middle of the array.
		
		int lowIndex = 0; //Because the array is in ascending order the smallest element will be in the 0th element 
		
		int highIndex = numbers.length - 1; //likewise, the largest number will be at the end of the array. 
		
		do {
			System.out.println("["+index + "] = " + numbers[index] + " | " + lowIndex + "<" + highIndex); // shows you what we are looking at
			if (number > numbers[index]) { //if the number is more than the current index
				lowIndex = index; //then the index is currently the smallest number we know of
				index += (highIndex - lowIndex) / 2; //we need to set a new index which is halfway between the current index, and the highIndex
			} else if (number < numbers[index]) { // the number is smaller than the index
				highIndex = index; //which makes the index the new upper bound
				index = index - (highIndex - lowIndex) / 2; // and index needs to be set the mid point between the new highest and the lowIndex
			} else {
				//if the number isn't larger, or it isn't smaller, we must have found it!
				System.out.println("FOUND!!!!" + "["+index + "] = " + numbers[index]); 
				searching = false; // stop searching
			}
			pause(500); //wait for a bit
		} while (searching);
		pause(2000);
	}

	
	/** 
	 * sorts the array into ascending order. 
	 */
	public static void sortArray() {
		System.out.println("sortArray()");
		long time = System.currentTimeMillis();
		int a, b;
		for (int i = 0; i < numbers.length; i++) {
			a = numbers[i];
			for (int j = i; j < numbers.length; j++) {
				if (numbers[j] < a) {
					b = numbers[j];
					numbers[j] = a;
					a = b;
					numbers[i] = b;
				}
			}
		}
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time);
	}

	/**
	 * populateArray fills the array with numbers from 1 - the length of the array. 
	 */
	public static void populateArray() {
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}
	}

	/**
	 * randomiseArray is a simplistic implementation of Collections.shuffle()
	 * Swaps the current iteration element with index. 
	 */
	private static void randomiseArray() {
		Random random = new Random(); //picks a random number
		int index; // the random index we will swap 
		for (int i = numbers.length - 1; i > 0; i--) {
			index = random.nextInt(i + 1); //assign the index 
			
			// swapping variables 
			int a = numbers[index]; 
			numbers[index] = numbers[i];
			numbers[i] = a;
		}
	}

	/**
	 * printArray prints the contents of the global array numbers. 
	 */
	private static void printArray() {
		for (int i : numbers) { // here be magic. 
			System.out.println(i);
		}
	}
	
	/**
	 * Pauses the program for a finite amount of time. 
	 * @param delay - the length of time that this program will sleep for. 
	 */
	private static void pause(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		populateArray(); //populates an array for you to use. 
		randomiseArray(); //makes that array random. 
		// printArray();  // prints the content of the array
		sortArray(); //sorts it back into order
		// printArray();
		
		
		// pick a number and let's go find it!
		int findNumber = 127;  
		findNumberInArray(findNumber);
		simpleSearch(findNumber);

	}
}
