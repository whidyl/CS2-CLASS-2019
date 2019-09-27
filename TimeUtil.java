import java.util.concurrent.TimeUnit;

// Program to calculate execution time or elapsed time in Java
class Main
{
	public static void main(String[] args) throws InterruptedException {
		int[] intArray100 = fillWithRandomInts(new int[100]);
		int[] intArray1000 = fillWithRandomInts(new int[1000]);
		int[] intArray5000 = fillWithRandomInts(new int[5000]);
		int[] intArray10000 = fillWithRandomInts(new int[10000]);

		timeBubblesort(intArray100);
		timeBubblesort(intArray1000);
		timeBubblesort(intArray5000);
		timeBubblesort(intArray10000);
	}

	private static void timeBubblesort(int[] intArray) {
		long startTime = System.nanoTime();
		BubbleSort.bubbleSort(intArray);
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("For bubblesorting an array of length " + intArray.length + ":");
		System.out.println("	Execution time in nanoseconds: " + timeElapsed);
		System.out.println("	Execution time in milliseconds: " + timeElapsed / 1000000);
	}

	private static int[] fillWithRandomInts(int[] ints) {
		// fills an int array with random ints from 0-99. The array is also returned.
		for (int i = 0; i < ints.length; i++) {
			ints[i] = (int) (Math.random()*100);
		}
		return ints;
	}
}