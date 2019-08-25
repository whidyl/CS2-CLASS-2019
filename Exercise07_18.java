/**
* (Bubble sort) Write a sort method that uses the bubble-sort algorithm. The bubble-sort algorithm 
* makes several passes through the array. On each pass, successive neighboring pairs are compared. 
* If a pair is not in order, its values are swapped; otherwise, the values remain unchanged. The 
* technique is called a bubble sort or sinking sort because the smaller values gradually “bubble” their
* way to the top, and the larger values “sink” to the bottom. Write a test program
* that reads in 10 double numbers, invokes the method, and displays the sorted
* numbers.
*/
import java.util.Scanner;
public class Exercise07_18 {
	
	public static void main(String args[]) {
		// receive list of ten doubles from user
		Scanner input = new Scanner(System.in);
		double[] list = new double[10];
		System.out.println("Enter ten double values: ");
		for(int i = 0; i < 10; i++) {
			list[i] = input.nextDouble();
		}
		// sort the list and display it.
		bubbleSort(list);
		System.out.println("The values have been sorted using the bubble-sort algorithm:");
		for (double n: list) {
			System.out.println(n);
		}
		input.close();
	}

	private static void bubbleSort(double[] list) {
		// Sorts a list of doubles using the bubbleSort algorithm
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 1; i < list.length; i++) {
				if (list[i-1] > list[i]) {
					swap(list, i-1, i);
					// the list is not considered sorted if any values need to be swapped.
					sorted = false;
				}
			}
		}
		
	}

	private static void swap(double[] list, int i1, int i2) {
		// Swaps the the values of index i1 and i2
		double tempValue = list[i1];
		list[i1] = list[i2];
		list[i2] = tempValue;
		
	}

}
