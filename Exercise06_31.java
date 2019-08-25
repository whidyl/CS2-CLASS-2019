import java.util.Scanner;

public class Exercise06_31 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a credit card number to see if it is valid: ");
		long cardNumber = input.nextLong();
		// 4388576018402626 should be an invalid card number. 
		// 4388576018410707 should be a valid card number
		if (isValid(cardNumber)) {
			System.out.println("This card number is valid.");
		} else {
			System.out.println("This card number is invalid.");
		}
		input.close();
	}
	
	
	 public static boolean isValid(long number) {
		 /** If the sum of sumOfDoubleEvenPlace(n) and sumOfOddPlace(n) is divisible by 10,
		  then n is a valid credit card number. */
		 int sum = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		 if (sum%10 == 0) {
			 return true;
		 } else {
			 return false;
		 }
	 }
	 
	 public static int sumOfDoubleEvenPlace(long number) {
		 /** Double every second digit from right to left. If doubling of a digit
		 results in a two-digit number, add up the two digits to get a single-
		 digit number and return it. */
		 
		 int sum = 0;
		 //Cut off first digit
		 number /= 10;
		 //Iterate through digits of number from right to left
		 while (number > 0) {
			 int digit = (int) (number%10);
			 sum += getDigit(digit*2);
			 number /= 100;
		 }
		 return sum;
	 }
	 
	 public static int getDigit(int number) {
		 /** Return this number if it is a single digit, otherwise,
			 * return the sum of the two digits */
		 if (number < 10) {
			 return number;    
		 } else if (number < 100){
			 int digit1 = number%10;
			 number /= 10;
			 int digit2 = number%10;
			 return digit1 + digit2;
		 } else {
			 System.out.println("getDigit(n) should only receive an argument that is 1 or 2 digits");
			 return 0;
		 }
	 }
	 
	 public static int sumOfOddPlace(long number) {
		 /** Return sum of odd-place digits in number */
		 int sum = 0;
		 while (number > 0) {
			 int digit = (int) (number%10);
			 sum += digit;
			 number /= 100;
		 }
		 return sum;
	 }
}
